package com.example.igor.sowinski.Allegro.Repo.domain.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class RepositoryServiceTest {

    private RepositoryService repositoryService = new RepositoryService();

    @Before
    public void setDefaultRepositoryAddress(){
        repositoryService.setServerAdress("https://api.github.com/users/allegro/repos");
    }

    @Test
    public void shouldFetchAllegroRepositories() {


        //given
        //when
        List<Repository> repositoryList = repositoryService.getRepositoryList();

        //then

        Assert.assertNotEquals(0, repositoryList.size());
    }

    @Test
    public void shouldReturnRepositoryWhereIsTheLatestUpdateDateCommit(){
        //given

        //when

        //then
    }



}