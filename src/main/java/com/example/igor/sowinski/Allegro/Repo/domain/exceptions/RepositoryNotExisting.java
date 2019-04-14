package com.example.igor.sowinski.Allegro.Repo.domain.exceptions;


import java.lang.reflect.InvocationTargetException;

public class RepositoryNotExisting extends RuntimeException {
    public RepositoryNotExisting(String message){
        super(message);
    }
}
