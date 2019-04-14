package com.example.igor.sowinski.allegro.repo.domain.exceptions;

public class RepositoryIsEmpty extends RuntimeException {
    public RepositoryIsEmpty(String message){
        super(message);
    }
}
