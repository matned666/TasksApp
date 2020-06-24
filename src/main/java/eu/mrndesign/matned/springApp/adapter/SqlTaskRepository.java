package eu.mrndesign.matned.springApp.adapter;

import eu.mrndesign.matned.springApp.model.Task;
import eu.mrndesign.matned.springApp.model.TaskRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@RepositoryRestResource
@Repository
interface SqlTaskRepository extends TaskRepository, JpaRepository<Task,Integer> {
    @Override
    @Query(nativeQuery = true, value = "select count(*) > 0 from tasks where id = :id")
    boolean existsById(@Param("id") Integer id);

    @Override
    boolean existsByDoneIsFalseAndGroup_Id(Integer groupId);

    //
//    Niepotrzebne przy @Repository
//    @Override
//    @RestResource(exported = false)
//    default void deleteById(Integer integer) {
//
//    }
//
//    @Override
//    @RestRes+ource(exported = false)
//    default void delete(Task task) {
//
//    }

//    @RestResource(path = "done", rel = "done")
}
