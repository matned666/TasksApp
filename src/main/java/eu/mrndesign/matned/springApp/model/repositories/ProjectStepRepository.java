package eu.mrndesign.matned.springApp.model.repositories;

import eu.mrndesign.matned.springApp.model.ProjectStep;

import java.util.List;

public interface ProjectStepRepository extends BaseRepository<ProjectStep> {

    List<ProjectStep> findByProject_Id(Integer projectId);

}
