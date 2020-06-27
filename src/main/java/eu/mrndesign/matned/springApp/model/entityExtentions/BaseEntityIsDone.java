package eu.mrndesign.matned.springApp.model.entityExtentions;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntityIsDone extends BaseEntityDescription{

    private boolean done;

    public boolean isDone() {
        return done;
    }

    public void setDone(final boolean done) {
        this.done = done;
    }


}
