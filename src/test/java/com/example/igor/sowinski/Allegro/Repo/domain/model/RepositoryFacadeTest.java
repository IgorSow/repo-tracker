package com.example.igor.sowinski.Allegro.Repo.domain.model;

import com.example.igor.sowinski.Allegro.Repo.api.dto.RepositoryNameDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RepositoryFacadeTest {




    @Test
    public void shouldReturnLatestRepositoryNameDto() {
        //given
        RepositoryService repositoryService = new RepositoryService("https://api.github.com/users/IgorSow/repos");
        RepositoryFacade repositoryFacade = new RepositoryFacade(repositoryService);

        List<Repository> repositoryList = repositoryService.getRepositoryList();
        List<Repository> orderListByUpdateDate = repositoryService.orderListByUpdateDate(repositoryList);
        Repository latestRepo = repositoryService.getLatestRepo(orderListByUpdateDate);


        //when

        RepositoryNameDto latestRepoDto = repositoryFacade.getLatestRepo();
        //then

        Assert.assertEquals(latestRepo.getName(), latestRepoDto.getNameRepository());


    }
}