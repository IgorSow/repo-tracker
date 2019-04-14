package com.example.igor.sowinski.allegro.repo.domain.model;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class RepositoryService {

    public RepositoryService() {
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
