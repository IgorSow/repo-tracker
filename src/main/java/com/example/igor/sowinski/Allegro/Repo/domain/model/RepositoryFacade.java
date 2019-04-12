package com.example.igor.sowinski.Allegro.Repo.domain.model;

import com.example.igor.sowinski.Allegro.Repo.api.dto.RepositoryNameDto;
import org.springframework.beans.factory.annotation.Value;

public class RepositoryFacade {



    private RepositoryService service;

    public RepositoryFacade(RepositoryService repositoryService) {
        this.service = repositoryService;
    }

    public RepositoryNameDto getLatestRepo(){
//        Repository latestRepo = service.orderListByUpdateDate();
//
//        RepositoryNameDto result = new RepositoryNameDto(latestRepo.getName());
        return null;
    }
}
