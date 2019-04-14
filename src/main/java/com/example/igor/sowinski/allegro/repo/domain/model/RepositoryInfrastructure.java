package com.example.igor.sowinski.allegro.repo.domain.model;

import com.example.igor.sowinski.allegro.repo.domain.exceptions.RepositoryIsEmpty;
import com.example.igor.sowinski.allegro.repo.domain.exceptions.RepositoryNotExisting;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class RepositoryInfrastructure {

    private RestTemplate restTemplate;
    private String serverAddress;
    private Logger logger = LoggerFactory.getLogger(RepositoryInfrastructure.class);

    public RepositoryInfrastructure(String serverAddress) {
        this.serverAddress = serverAddress;
        this.restTemplate = new RestTemplate();
    }

    List<Repository> getRepositoryList() throws RepositoryNotExisting, RepositoryIsEmpty {

        try {
            ResponseEntity<List<Repository>> response = restTemplate.exchange(
                    serverAddress,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Repository>>() {
                    });

            List<Repository> repositoryList = response.getBody();
            checkIsEmpty(repositoryList);
            logger.info("INFRASTRUCTURE getRepositoryList()- result: Fetch size: " + repositoryList.size());
            return repositoryList;
        } catch (HttpClientErrorException e ) {
            e.printStackTrace();
            logger.error("INFRASTRUCTURE getRepositoryList()- result: " + e.getMessage());
            throw new RepositoryNotExisting(e.getMessage());
        }
    }
    private void checkIsEmpty(List<Repository> list){
        if(list.isEmpty()){
            logger.error("INFRASTRUCTURE checkIsEmpty()- result: " + "Account have no repositories");
            throw new RepositoryIsEmpty("Account have no repositories");
        }
    }
}
