package com.example.igor.sowinski.Allegro.Repo.domain.exceptions;

public class RepositoryIsEmpty extends RuntimeException {
    public RepositoryIsEmpty(String message){
        super(message);
    }
}
