package eu.mrndesign.matned.springApp.model.repositories;

import eu.mrndesign.matned.springApp.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends BaseRepository<Task>{


    Page<Task> findAll(Pageable pageable);

    boolean existsByDoneIsFalseAndGroup_Id(Integer groupId);

    boolean existsById(Integer id);

    List<Task> findByDone(@Param("state") boolean done);

}
