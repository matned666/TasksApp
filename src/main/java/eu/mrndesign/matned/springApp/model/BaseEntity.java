package eu.mrndesign.matned.springApp.model;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
public abstract class BaseEntity {

    @NotBlank(message = "Task description must not be empty.")
    private String description;
    private boolean done;

    //    JUST A NOTE:
//    @AttributeOverrides( można dać override do kolumn a klasy embedded
//            {
//                    @AttributeOverride(column = @Column(name = "createdOn"), name = "createdOn")
//                    @AttributeOverride(column = @Column(name = "updatedOn"), name = "updatedOn")
//            }
//    )
    @Embedded
    private Audit audit = new Audit();

    public String getDescription() {
        return description;
    }

    void setDescription(final String description) {
        this.description = description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(final boolean done) {
        this.done = done;
    }


}
