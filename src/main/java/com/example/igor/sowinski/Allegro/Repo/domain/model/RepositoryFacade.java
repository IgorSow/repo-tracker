package com.example.igor.sowinski.Allegro.Repo.domain.model;

import com.example.igor.sowinski.Allegro.Repo.api.dto.RepositoryNameDto;

public class RepositoryFacade {



    private RepositoryService service;

    public RepositoryFacade(RepositoryService repositoryService) {
        this.service = repositoryService;
    }

    public RepositoryNameDto getLatestRepo(){
        Repository lasterRepo = service.getLasterRepo();

        RepositoryNameDto result = new RepositoryNameDto(lasterRepo.getName());
        return result;
    }
}
