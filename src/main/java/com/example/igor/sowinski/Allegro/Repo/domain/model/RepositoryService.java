package com.example.igor.sowinski.Allegro.Repo.domain.model;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;


class RepositoryService {


    private RestTemplate restTemplate;

    @Value("${allegro.repository.address.url}")
    private String serverAdress;


    public RepositoryService() {

        this.restTemplate = new RestTemplate();
    }

    public void setServerAdress(String serverAdress) {
        this.serverAdress = serverAdress;
    }

    protected List<Repository> getRepositoryList() {

        ResponseEntity<List<Repository>> response = restTemplate.exchange(
                serverAdress,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Repository>>() {
                });

        List<Repository> repositoryList = response.getBody();
        System.out.println(repositoryList);
        return repositoryList;
    }

    public Repository getLatest() {

        getRepositoryList();
        return null;
    }

}
