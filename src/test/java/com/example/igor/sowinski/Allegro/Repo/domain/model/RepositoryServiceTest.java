package com.example.igor.sowinski.Allegro.Repo.domain.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class RepositoryServiceTest {

    private RepositoryService repositoryService = new RepositoryService();
    private RepositoryInfrastructure infrastructure = new RepositoryInfrastructure("https://api.github.com/users/allegro/repos");


    @Test
    public void shouldFetchAllegroRepositories() {

        //given
        //when
        List<Repository> repositoryList = infrastructure.getRepositoryList();

        //then
        Assert.assertNotEquals(0, repositoryList.size());
    }

    @Test
    public void shouldReturnOrderedListByDateUpdate(){
        //given
        List<Repository> repositoryList = infrastructure.getRepositoryList();
        int compareLatestObject = 1;
        int compareOlderObject = -1;
        int compareTheSameObject = 0;

        //when
        List<Repository> orderedList = repositoryService.orderListByUpdateDate(repositoryList);

        Repository lastRepository = orderedList.get(orderedList.size() -1);
        Repository olderRepository = orderedList.get(1);

        //then

        int resultCompare = lastRepository.getUpdated_at().compareTo(olderRepository.getUpdated_at());

        Assert.assertEquals(compareLatestObject, resultCompare);
        Assert.assertNotEquals(compareOlderObject, resultCompare);
        Assert.assertNotEquals(compareTheSameObject, resultCompare);

    }

    @Test
    public void shouldReturnRepositoryWhereIsTheLatestUpdateDateCommit(){

        //given
        List<Repository> repositoryList = infrastructure.getRepositoryList();

        //when
        List<Repository> orderedList = repositoryService.orderListByUpdateDate(repositoryList);

        Repository lastObject = orderedList.get(orderedList.size() -1);

        Repository latestRepo = repositoryService.getLatestRepo(orderedList);

        //then
        Assert.assertEquals(lastObject, latestRepo);
    }

}