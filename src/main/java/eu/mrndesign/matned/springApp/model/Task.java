package eu.mrndesign.matned.springApp.model;

import eu.mrndesign.matned.springApp.model.entityExtentions.BaseEntityIsDone;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "tasks")
public class Task extends BaseEntityIsDone {

    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private long id;

    private LocalDateTime deadline;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "task_group_id")
    private TaskGroup group;

    public Task() {
    }

    public long getId() {
        return id;
    }

    void setId(final long id) {
        this.id = id;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    TaskGroup getGroup() {
        return group;
    }

    public void updateFrom(final Task source){
        setDescription(source.getDescription());
        setDone(source.isDone());
        deadline = source.deadline;
        group = source.group;
    }


}
