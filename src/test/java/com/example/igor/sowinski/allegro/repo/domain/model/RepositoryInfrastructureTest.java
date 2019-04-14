package com.example.igor.sowinski.allegro.repo.domain.model;

import com.example.igor.sowinski.allegro.repo.domain.exceptions.RepositoryIsEmpty;
import com.example.igor.sowinski.allegro.repo.domain.exceptions.RepositoryNotExisting;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RepositoryInfrastructureTest {

    private Logger logger = LoggerFactory.getLogger(RepositoryFacadeTest.class);

    @Test
    public void shouldFetchAllegroRepositories() {
        //given
        RepositoryInfrastructure infrastructure = new RepositoryInfrastructure("https://api.github.com/users/IgorSow/repos");

        //when
        List<Repository> repositoryList = infrastructure.getRepositoryList();

        //then
        repositoryList.stream()
                .forEach((repository -> logger.info("TEST shouldFetchAllegroRepositories()- " +
                        "result: Name:" + repository.getName() +
                        "last update:" + repository.getUpdated_at())));

        logger.info("TEST shouldFetchAllegroRepositories()- result: Size : " + repositoryList.size());

        Assert.assertNotEquals(0, repositoryList.size());
    }

    @Test
    public void shouldThrowExceptionRepositoryNotExisting() {
        //given
        RepositoryInfrastructure notExistingRepository = new RepositoryInfrastructure("https://api.github.com/users/fasdfasdvqwfwqvzzasdw/repos");
        //when
        try {
            List<Repository> repositoryList = notExistingRepository.getRepositoryList();
            //then
            logger.error("TEST shouldThrowExceptionRepositoryNotExisting()- result: should throw exception");
            Assert.assertTrue(false);
        } catch (RepositoryNotExisting e) {
            logger.info("TEST shouldThrowExceptionRepositoryNotExisting()- result: " + e.getMessage());
           Assert.assertTrue(true);
        }
    }

    @Test
    public void shouldThrowExceptionRepositoryIsEmpty(){
        //given
        RepositoryInfrastructure emptyRepository = new RepositoryInfrastructure("https://api.github.com/users/milenka1991/repos");
        //when
        try {
            List<Repository> repositoryList = emptyRepository.getRepositoryList();
            //then
            logger.error("TEST  shouldThrowExceptionRepositoryIsEmpty()- result: should throw exception");
            Assert.assertTrue(false);
        } catch (RepositoryIsEmpty e) {
            logger.info("TEST shouldThrowExceptionRepositoryIsEmpty()- result: " + e.getMessage());
            Assert.assertTrue(true);
        }
    }
}