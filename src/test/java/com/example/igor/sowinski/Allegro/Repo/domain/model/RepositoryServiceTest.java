package com.example.igor.sowinski.Allegro.Repo.domain.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class RepositoryServiceTest {

    private RepositoryService repositoryService = new RepositoryService("https://api.github.com/users/allegro/repos");


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
        List<Repository> repositoryList = repositoryService.getRepositoryList();
        int compareLatestObject = 1;
        int compareOlderrObject = -1;
        int compareTheSameObject = 0;

        //when
        List<Repository> orderedList = repositoryService.orderListByUpdateDate(repositoryList);

        Repository lastRepository = orderedList.get(orderedList.size() -1);
        Repository olderRepository = orderedList.get(1);

        //then

        int resultCompare = lastRepository.getUpdated_at().compareTo(olderRepository.getUpdated_at());

        Assert.assertEquals(compareLatestObject, resultCompare);
        Assert.assertNotEquals(compareOlderrObject, resultCompare);
        Assert.assertNotEquals(compareTheSameObject, resultCompare);

    }



}