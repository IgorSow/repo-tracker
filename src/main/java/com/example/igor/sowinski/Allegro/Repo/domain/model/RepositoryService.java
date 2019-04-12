package com.example.igor.sowinski.Allegro.Repo.domain.model;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class RepositoryService {


    private RestTemplate restTemplate;
    private String serverAddress;

    public RepositoryService(String serverAddress) {
        this.restTemplate = new RestTemplate();
        this.serverAddress = serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    List<Repository> getRepositoryList() {

        ResponseEntity<List<Repository>> response = restTemplate.exchange(
                serverAddress,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Repository>>() {
                });

        List<Repository> repositoryList = response.getBody();
        return repositoryList;
    }

    List<Repository> orderListByUpdateDate(List<Repository> repositoryList) {

        Collections.sort(repositoryList, new RepoUpdateDateComparator());

        return repositoryList;
    }

    Repository getLatestRepo(List<Repository> orderedRepositoryByDate){
        return orderedRepositoryByDate.get(orderedRepositoryByDate.size() -1);
    }

}

class RepoUpdateDateComparator implements Comparator<Repository> {
    @Override
    public int compare(Repository repo1, Repository repo2) {
        return repo1.getUpdated_at().compareTo(repo2.getUpdated_at());
    }
}
