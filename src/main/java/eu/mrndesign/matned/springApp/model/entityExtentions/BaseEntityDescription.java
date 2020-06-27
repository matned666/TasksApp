package eu.mrndesign.matned.springApp.model.entityExtentions;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;

@MappedSuperclass
public abstract class BaseEntityDescription extends BaseEntityAudit{

    @NotBlank(message = "Task description must not be empty.")
    private String description;

    public String getDescription() {
        return description;
    }

    protected void setDescription(final String description) {
        this.description = description;
    }
}
