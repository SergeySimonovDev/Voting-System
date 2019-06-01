package ru.internship.ballot.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@MappedSuperclass
public abstract class AbstractTitleEntity extends AbstractBaseEntity {

    @Column(name = "title", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    protected String title;

    protected AbstractTitleEntity() {
    }

    public AbstractTitleEntity(Integer id, String title) {
        super(id);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return String.format("Entity %s (%s, '%s')", getClass().getName(), id, title);
    }
}
