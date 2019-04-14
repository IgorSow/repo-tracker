package com.example.igor.sowinski.allegro.repo.domain.model;

import com.example.igor.sowinski.allegro.repo.api.dto.RepositoryNameDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class RepositoryFacadeTest {

    @Test
    public void shouldReturnLatestRepositoryNameDto() {
        //given
        RepositoryService repositoryService = new RepositoryService();
        RepositoryInfrastructure infrastructure = new RepositoryInfrastructure("https://api.github.com/users/IgorSow/repos");
        RepositoryFacade repositoryFacade = new RepositoryFacade(repositoryService, infrastructure);

        List<Repository> repositoryList = infrastructure.getRepositoryList();
        List<Repository> orderListByUpdateDate = repositoryService.orderListByUpdateDate(repositoryList);
        Repository latestRepo = repositoryService.getLatestRepo(orderListByUpdateDate);

        //when
        RepositoryNameDto latestRepoDto = repositoryFacade.getLatestRepo();

        //then
        Assert.assertEquals(latestRepo.getName(), latestRepoDto.getNameRepository());
    }
}