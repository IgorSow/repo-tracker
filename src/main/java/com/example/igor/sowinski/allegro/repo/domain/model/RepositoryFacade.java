package com.example.igor.sowinski.allegro.repo.domain.model;

import com.example.igor.sowinski.allegro.repo.api.dto.RepositoryNameDto;

import java.util.List;

public class RepositoryFacade {

    private RepositoryService service;
    private RepositoryInfrastructure infrastructure;

    public RepositoryFacade(RepositoryService repositoryService, RepositoryInfrastructure infrastructure) {
        this.service = repositoryService;
        this.infrastructure = infrastructure;
    }

    public RepositoryNameDto getLatestRepo(){
        List<Repository> repositoryList = infrastructure.getRepositoryList();

        List<Repository> orderListByUpdateDate = service.orderListByUpdateDate(repositoryList);

        Repository result = service.getLatestRepo(orderListByUpdateDate);

        return RepositoryMapper.getDto(result);
    }
}

class RepositoryMapper{
    static RepositoryNameDto getDto(Repository repository){
       return new RepositoryNameDto(repository.getName());
    }
}
