package com.example.igor.sowinski.Allegro.Repo.api.dto;

public class RepositoryNameDto {


    private String nameRepository;

    public RepositoryNameDto(String nameRepository) {
        this.nameRepository = nameRepository;
    }

    public String getNameRepository() {
        return nameRepository;
    }

    public void setNameRepository(String nameRepository) {
        this.nameRepository = nameRepository;
    }
}
