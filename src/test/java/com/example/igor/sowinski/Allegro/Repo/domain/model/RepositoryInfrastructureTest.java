package com.example.igor.sowinski.Allegro.Repo.domain.model;

import com.example.igor.sowinski.Allegro.Repo.domain.exceptions.RepositoryIsEmpty;
import com.example.igor.sowinski.Allegro.Repo.domain.exceptions.RepositoryNotExisting;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class RepositoryInfrastructureTest {



    @Test
    public void shouldFetchAllegroRepositories() {
        RepositoryInfrastructure infrastructure = new RepositoryInfrastructure("https://api.github.com/users/IgorSow/repos");
        //given
        //when
        List<Repository> repositoryList = infrastructure.getRepositoryList();

        //then
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
            Assert.assertTrue(false);
        } catch (RepositoryNotExisting e) {
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
            Assert.assertTrue(false);
        } catch (RepositoryIsEmpty e) {
            Assert.assertTrue(true);
        }
    }
}