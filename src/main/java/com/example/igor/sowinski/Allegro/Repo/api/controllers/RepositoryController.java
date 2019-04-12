package com.example.igor.sowinski.Allegro.Repo.api.controllers;


import com.example.igor.sowinski.Allegro.Repo.api.dto.RepositoryNameDto;
import com.example.igor.sowinski.Allegro.Repo.domain.model.RepositoryFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class RepositoryController {



    private RepositoryFacade facade;

    public RepositoryController(RepositoryFacade facade) {
        this.facade = facade;
    }

    @GetMapping("/getLatest")
    public ResponseEntity getLasted() {


        RepositoryNameDto repositoryNameDto = facade.getLatestRepo();


        return new ResponseEntity(repositoryNameDto, HttpStatus.OK);

    }
}
