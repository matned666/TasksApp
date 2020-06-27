package eu.mrndesign.matned.springApp.controller;

import eu.mrndesign.matned.springApp.model.Task;
import eu.mrndesign.matned.springApp.model.repositories.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;


//@Controller controller jest dodany do RestController
@RestController // częściej używane Repository jest schowane
public class TaskController {
    public static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final TaskRepository repository;

    TaskController(TaskRepository repository) {
        this.repository = repository;
    }

     @GetMapping(value = "/tasks", params = {"!sort","!page","!size"})
//    @RequestMapping(method = RequestMethod.GET, path = "/tasks", params = {"!sort","!page","!size"}) stara wersja
    ResponseEntity<List<Task>> readAllTasks(){
        logger.warn("Exposing all the tasks");
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/tasks")
    ResponseEntity<Page<Task>> readAllTasks(Pageable pageable){
        logger.warn("Exposing all the tasks");
        return ResponseEntity.ok(repository.findAll( pageable));
    }

//    @PathVariable("id") int taskIdBleBleBle)
//    - jeśli inna nazwa zmiennej niż w naszym adresie url,
//      trzeba doprecyzować w nawiasie
    @PutMapping("/tasks/{id}")
//    @RequestMapping(method = RequestMethod.PUT, path = "/tasks/{id}") stara wersja
    ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody @Valid Task toUpdate){
        if(!repository.existsById(id)) return ResponseEntity.notFound().build();
        repository.findById(id)
                .ifPresent(task -> {
                    task.updateFrom(toUpdate);
                    repository.save(task);
                });
        return ResponseEntity.noContent().build();
    }

    @Transactional
    @PatchMapping("/tasks/{id}")
    public ResponseEntity<Task> toggleTask(@PathVariable int id){
        if(!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.findById(id)
                .ifPresent(task -> task.setDone(!task.isDone()));
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tasks/{id}")
//    @RequestMapping(method = RequestMethod.GET, path = "/tasks/{id}")  stara wersja
    ResponseEntity<Task> readTask(@PathVariable int id){
        return repository.findById(id)
                .map(task -> ResponseEntity.ok(task))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/tasks")
//    @RequestMapping(method = RequestMethod.POST, path = "/tasks") stara wersja
    ResponseEntity<Task> postTask(@RequestBody @Valid Task toPost){
        Task result = repository.save(toPost);
        return ResponseEntity.created(URI.create("/"+result.getId())).body(result);
    }




}
