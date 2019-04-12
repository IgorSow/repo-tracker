package com.example.igor.sowinski.Allegro.Repo.domain.model;

class Repository {

    private String name;
    private boolean isPrivate;
    private String created_at;
    private String updated_at;
    private String pushed_at;
    private String language;

    public Repository(String name, boolean isPrivate, String created_at, String updated_at, String pushed_at, String language) {
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

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getPushed_at() {
        return pushed_at;
    }

    public void setPushed_at(String pushed_at) {
        this.pushed_at = pushed_at;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Repository{" +
                "name='" + name + '\'' +
                ", isPrivate=" + isPrivate +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                ", pushed_at='" + pushed_at + '\'' +
                ", language='" + language + '\'' +
                + '\'' +
                + '\'' +
                '}';
    }
}

