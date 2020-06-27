package eu.mrndesign.matned.springApp.model;

import eu.mrndesign.matned.springApp.model.entityExtentions.BaseEntityDescription;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDateTime;
import static java.time.temporal.ChronoUnit.DAYS;

@Entity
@Table(name = "project_steps")
public class ProjectStep extends BaseEntityDescription {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private long id;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "project_id")
    private Project project;

    private long daysLeft;

    public ProjectStep() {
    }

    public long getId() {
        return id;
    }

    void setId(long id) {
        this.id = id;
    }

    public Project getProject() {
        return project;
    }

    void setProject(Project project) {
        this.project = project;
    }

    public long getDaysLeft() {
        return daysLeft;
    }

    void setDaysLeft(long daysLeft) {
        this.daysLeft = daysLeft;
    }
}
