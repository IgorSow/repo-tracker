package com.example.igor.sowinski.Allegro.Repo.domain.exceptions;

public class RepositoryNotExisting extends RuntimeException {
    public RepositoryNotExisting(String message){
        super(message);
    }
}
