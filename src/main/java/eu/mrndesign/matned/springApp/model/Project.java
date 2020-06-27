package eu.mrndesign.matned.springApp.model;

import eu.mrndesign.matned.springApp.model.entityExtentions.BaseEntityDescription;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "project")
public class Project extends BaseEntityDescription {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "project")
    private Set<TaskGroup> taskGroups;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "project")
    private Set<ProjectStep> projectSteps;



    public Project() {
    }

    public long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    Set<TaskGroup> getTaskGroups() {
        return taskGroups;
    }

    void setTaskGroups(Set<TaskGroup> taskGroups) {
        this.taskGroups = taskGroups;
    }

    Set<ProjectStep> getProjectSteps() {
        return projectSteps;
    }

    void setProjectSteps(Set<ProjectStep> projectSteps) {
        this.projectSteps = projectSteps;
    }
}
