package com.example.igor.sowinski.allegro.repo.domain.exceptions;

public class RepositoryNotExisting extends RuntimeException {
    public RepositoryNotExisting(String message){
        super(message);
    }
}
