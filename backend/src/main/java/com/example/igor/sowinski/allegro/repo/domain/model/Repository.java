package com.example.igor.sowinski.allegro.repo.domain.model;

import java.time.Instant;

class Repository {

    private String name;
    private boolean isPrivate;
    private Instant created_at;
    private Instant updated_at;
    private Instant pushed_at;
    private String language;

    public Repository(String name, boolean isPrivate, Instant created_at, Instant updated_at, Instant pushed_at, String language) {
        this.name = name;
        this.isPrivate = isPrivate;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.pushed_at = pushed_at;
        this.language = language;
    }

    public Repository() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Instant getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Instant created_at) {
        this.created_at = created_at;
    }

    public Instant getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Instant updated_at) {
        this.updated_at = updated_at;
    }

    public Instant getPushed_at() {
        return pushed_at;
    }

    public void setPushed_at(Instant pushed_at) {
        this.pushed_at = pushed_at;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}

