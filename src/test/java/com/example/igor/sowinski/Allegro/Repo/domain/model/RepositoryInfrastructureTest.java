package com.example.igor.sowinski.Allegro.Repo.domain.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RepositoryInfrastructureTest {

    private RepositoryInfrastructure infrastructure = new RepositoryInfrastructure("https://api.github.com/users/allegro/repos");

    @Test
    public void shouldFetchAllegroRepositories() {

        //given
        //when
        List<Repository> repositoryList = infrastructure.getRepositoryList();

        //then
        Assert.assertNotEquals(0, repositoryList.size());
    }
}