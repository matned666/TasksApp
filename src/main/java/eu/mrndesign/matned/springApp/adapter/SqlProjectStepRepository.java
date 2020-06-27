package eu.mrndesign.matned.springApp.adapter;

import eu.mrndesign.matned.springApp.model.ProjectStep;
import eu.mrndesign.matned.springApp.model.repositories.ProjectStepRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SqlProjectStepRepository extends ProjectStepRepository, JpaRepository<ProjectStep, Integer> {

    @Override
    @Query("from ProjectStep g join fetch g.project where g.project.id =: id")
    List<ProjectStep> findByProject_Id(Integer projectId);


}
