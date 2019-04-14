package com.example.igor.sowinski.allegro.repo.domain.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class RepositoryService {

    public RepositoryService() {
    }
    List<Repository> orderListByUpdateDate(List<Repository> repositoryList) {
        Collections.sort(repositoryList, Comparator.comparing(Repository::getUpdated_at));
        return repositoryList;
    }

    Repository getLatestRepo(List<Repository> orderedRepositoryByDate){
        return orderedRepositoryByDate.get(orderedRepositoryByDate.size() -1);
    }
}
