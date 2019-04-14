package com.example.igor.sowinski.Allegro.Repo.domain.model;

import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class RepositoryServiceTest {

    private RepositoryService repositoryService = new RepositoryService();

    private RepositoryInfrastructure repoContainMinTwoRepository = new RepositoryInfrastructure("https://api.github.com/users/allegro/repos");
    private RepositoryInfrastructure notExcistingRepository = new RepositoryInfrastructure("https://api.github.com/users/fasdfasdvqwfwqvzzasdw/repos");
    private RepositoryInfrastructure excistingEmptyRepository = new RepositoryInfrastructure("https://api.github.com/users/allegro/repos");


    @Test
    public void shouldSortListDescending(){
        //given
        Repository repo1= new Repository("repo1", false, Instant.now(), Instant.now().plus(2, ChronoUnit.MINUTES), Instant.now(), "JAVA");
        Repository repo2= new Repository("repo2", false, Instant.now(), Instant.now().plus(3, ChronoUnit.MINUTES), Instant.now(), "JAVA");
        Repository repo3= new Repository("repo3", false, Instant.now(), Instant.now().plus(1, ChronoUnit.MINUTES), Instant.now(), "JAVA");
        Repository repo4= new Repository("repo4", false, Instant.now(), Instant.now().plus(4, ChronoUnit.MINUTES), Instant.now(), "JAVA");

        List<Repository> repositoryList = new ArrayList<>();
        repositoryList.add(repo1);
        repositoryList.add(repo2);
        repositoryList.add(repo3);
        repositoryList.add(repo4);
        //when

        List<Repository> orderListByUpdateDate = this.repositoryService.orderListByUpdateDate(repositoryList);

        //then

        Assert.assertEquals(repo4, orderListByUpdateDate.get(3));
        Assert.assertEquals(repo3, orderListByUpdateDate.get(0));
        Assert.assertEquals(repo1, orderListByUpdateDate.get(1));
        Assert.assertEquals(repo2, orderListByUpdateDate.get(2));
    }
    @Test
    public void shouldReturnOrderedListByDateUpdate(){
        //given
        List<Repository> repositoryList = repoContainMinTwoRepository.getRepositoryList();
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
        List<Repository> repositoryList = repoContainMinTwoRepository.getRepositoryList();

        //when
        List<Repository> orderedList = repositoryService.orderListByUpdateDate(repositoryList);

        Repository lastObject = orderedList.get(orderedList.size() -1);

        Repository latestRepo = repositoryService.getLatestRepo(orderedList);

        //then
        Assert.assertEquals(lastObject, latestRepo);
    }

}