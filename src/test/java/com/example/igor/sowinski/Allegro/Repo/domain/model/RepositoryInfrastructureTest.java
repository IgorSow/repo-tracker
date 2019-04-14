package com.example.igor.sowinski.Allegro.Repo.domain.model;

import com.example.igor.sowinski.Allegro.Repo.domain.exceptions.RepositoryNotExisting;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class RepositoryInfrastructureTest {

    private RepositoryInfrastructure infrastructure = new RepositoryInfrastructure("https://api.github.com/users/IgorSow/repos");
    private RepositoryInfrastructure excistingEmptyRepository = new RepositoryInfrastructure("https://api.github.com/users/allegro/repos");

    @Test
    public void shouldFetchAllegroRepositories() {

        //given
        //when
        List<Repository> repositoryList = infrastructure.getRepositoryList();

        //then
        Assert.assertNotEquals(0, repositoryList.size());
    }

    @Test
    public void shouldThrowExceptionNotExistingRepository() {
        //given
        RepositoryInfrastructure notExistingRepository = new RepositoryInfrastructure("https://api.github.com/users/fasdfasdvqwfwqvzzasdw/repos");
        //when
        try {
            List<Repository> repositoryList = notExistingRepository.getRepositoryList();
            //then
            Assert.assertTrue(false);
        } catch (RepositoryNotExisting e) {
            System.out.println("AAAAAAAAAAAAAAAAAAAAAA");
           Assert.assertTrue(true);
        }
    }
}