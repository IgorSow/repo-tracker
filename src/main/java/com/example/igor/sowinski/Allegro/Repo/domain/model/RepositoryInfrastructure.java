package com.example.igor.sowinski.Allegro.Repo.domain.model;

import com.example.igor.sowinski.Allegro.Repo.domain.exceptions.RepositoryNotExisting;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RepositoryInfrastructure {



    private RestTemplate restTemplate;
    private String serverAddress;

    public RepositoryInfrastructure(String serverAddress) {
        this.serverAddress = serverAddress;
        this.restTemplate = new RestTemplate();
    }

    List<Repository> getRepositoryList() {

        try {
            ResponseEntity<List<Repository>> response = restTemplate.exchange(
                    serverAddress,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Repository>>() {
                    });

            List<Repository> repositoryList = response.getBody();
            return repositoryList;
        } catch (Throwable e ) {
            e.printStackTrace();
            throw new RepositoryNotExisting(e.getMessage());
        }
    }
}
