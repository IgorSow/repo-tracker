package com.example.igor.sowinski.allegro.repo.api.controllers;

import com.example.igor.sowinski.allegro.repo.api.dto.RepositoryNameDto;
import com.example.igor.sowinski.allegro.repo.domain.model.RepositoryFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepositoryControllers {
    private RepositoryFacade facade;

    public RepositoryControllers(RepositoryFacade facade) {
        this.facade = facade;
    }

    @GetMapping("/allegro-last-updated-repository")
    public ResponseEntity getLasted() {


        RepositoryNameDto repositoryNameDto = facade.getLatestRepo();


        return new ResponseEntity(repositoryNameDto, HttpStatus.OK);

    }
}