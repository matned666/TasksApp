package eu.mrndesign.matned.springApp.adapter;

import eu.mrndesign.matned.springApp.model.Project;
import eu.mrndesign.matned.springApp.model.repositories.ProjectRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SqlProjectRepository extends ProjectRepository, JpaRepository<Project, Integer> {

    @Override
    @Query("from Project g")
    List<Project> findAll();

}
