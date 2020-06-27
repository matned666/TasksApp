package eu.mrndesign.matned.springApp.model.entityExtentions;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntityAudit {

    @Embedded
    private Audit audit = new Audit();
}
