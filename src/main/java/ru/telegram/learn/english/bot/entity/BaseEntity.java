package ru.telegram.learn.english.bot.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.lang.NonNull;

public abstract class BaseEntity implements Persistable<String> {
    @Id
    @Column
    protected String id;
    @Transient
    protected Boolean isNew;

    public BaseEntity(String id, Boolean isNew) {
        this.id = id;
        this.isNew = isNew;
    }

    @Override
    @NonNull
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean isNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }
}

