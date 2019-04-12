package com.example.igor.sowinski.Allegro.Repo.domain.model;

import com.example.igor.sowinski.Allegro.Repo.api.dto.RepositoryNameDto;

import java.util.List;

public class RepositoryFacade {



    private RepositoryService service;

    public RepositoryFacade(RepositoryService repositoryService) {
        this.service = repositoryService;
    }

    public RepositoryNameDto getLatestRepo(){
        List<Repository> repositoryList = service.getRepositoryList();

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
