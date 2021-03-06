package com.example.igor.sowinski.allegro.repo.domain.model;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class RepositoryServiceTest {

    private Logger logger = LoggerFactory.getLogger(RepositoryServiceTest.class);
    private RepositoryService repositoryService = new RepositoryService();
    private RepositoryInfrastructure accountContainMinTwoRepository = new RepositoryInfrastructure("https://api.github.com/users/allegro/repos");

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
        repositoryList.stream()
                .forEach((repository -> logger.info("TEST shouldSortListDescending()- " +
                        "result: Name:" + repository.getName() +
                        "last update:" + repository.getUpdated_at())));

        Assert.assertEquals(repo4, orderListByUpdateDate.get(3));
        Assert.assertEquals(repo3, orderListByUpdateDate.get(0));
        Assert.assertEquals(repo1, orderListByUpdateDate.get(1));
        Assert.assertEquals(repo2, orderListByUpdateDate.get(2));
    }

    @Test
    public void shouldReturnOrderedListByDateUpdate(){
        //given
        List<Repository> repositoryList = accountContainMinTwoRepository.getRepositoryList();
        int compareLatestObject = 1;
        int compareOlderObject = -1;
        int compareTheSameObject = 0;

        //when
        List<Repository> orderedList = repositoryService.orderListByUpdateDate(repositoryList);
        Repository lastRepository = orderedList.get(orderedList.size() -1);
        Repository olderRepository = orderedList.get(1);

        //then
        int resultCompare = lastRepository.getUpdated_at().compareTo(olderRepository.getUpdated_at());

        logger.info("TEST shouldReturnOrderedListByDateUpdate() - result: " + resultCompare);
        Assert.assertEquals(compareLatestObject, resultCompare);
        Assert.assertNotEquals(compareOlderObject, resultCompare);
        Assert.assertNotEquals(compareTheSameObject, resultCompare);
    }

    @Test
    public void shouldReturnRepositoryWhereIsTheLatestUpdateDateCommit(){

        //given
        List<Repository> repositoryList = accountContainMinTwoRepository.getRepositoryList();

        //when
        List<Repository> orderedList = repositoryService.orderListByUpdateDate(repositoryList);
        Repository lastOrder = orderedList.get(orderedList.size() -1);
        Repository lastFromService = repositoryService.getLatestRepo(orderedList);

        //then
        logger.info("TEST shouldReturnRepositoryWhereIsTheLatestUpdateDateCommit()- " +
                "result: Name:" + lastOrder.getName() +
                " Last update:" + lastOrder.getUpdated_at());

        logger.info("TEST shouldReturnRepositoryWhereIsTheLatestUpdateDateCommit()- " +
                "result: Name:" + lastFromService.getName() +
                " Last update:" + lastFromService.getUpdated_at());

        Assert.assertEquals(lastOrder, lastFromService);
    }
    
    @Test
    public void shouldSortIfExistingOnlyOneRepository(){
        //given
        Repository repo1= new Repository("repo1", false, Instant.now(), Instant.now().plus(2, ChronoUnit.MINUTES), Instant.now(), "JAVA");
        List<Repository> repositoryList = new ArrayList<>();
        repositoryList.add(repo1);

        //when
        List<Repository> orderListByUpdateDate = this.repositoryService.orderListByUpdateDate(repositoryList);

        //then
        logger.info("TEST shouldSortIfExistingOnlyOneRepository()- " +
                "result: Name:" + repo1.getName() +
                " Last update:" + repo1.getUpdated_at());

        logger.info("TEST shouldSortIfExistingOnlyOneRepository()- " +
                "result: Name:" + orderListByUpdateDate.get(0).getName() +
                " Last update:" + orderListByUpdateDate.get(0).getUpdated_at());

        Assert.assertEquals(repo1, orderListByUpdateDate.get(0));
    }
}