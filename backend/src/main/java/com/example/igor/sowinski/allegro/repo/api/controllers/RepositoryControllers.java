package com.example.igor.sowinski.allegro.repo.api.controllers;

import com.example.igor.sowinski.allegro.repo.api.dto.RepositoryNameDto;
import com.example.igor.sowinski.allegro.repo.domain.exceptions.RepositoryIsEmpty;
import com.example.igor.sowinski.allegro.repo.domain.exceptions.RepositoryNotExisting;
import com.example.igor.sowinski.allegro.repo.domain.model.RepositoryFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepositoryControllers {
    private RepositoryFacade facade;
    private Logger logger = LoggerFactory.getLogger(RepositoryControllers.class);

    public RepositoryControllers(RepositoryFacade facade) {
        this.facade = facade;
    }

    @CrossOrigin
    @GetMapping("/allegro-last-updated-repository")
    public ResponseEntity<RepositoryNameDto> getLasted() {
        RepositoryNameDto repositoryNameDto = facade.getLatestRepo();

        logger.info("REST CONTROLLER RepositoryControllers()- result: " + repositoryNameDto);
        return new ResponseEntity(repositoryNameDto, HttpStatus.OK);
    }

    @ExceptionHandler({RepositoryIsEmpty.class})
    private ResponseEntity<RepositoryNameDto> repositoryIsEmpty(RepositoryIsEmpty e){
        e.printStackTrace();
        logger.error("REST CONTROLLER repositoryIsEmpty- result: " + e.getMessage());
        return new ResponseEntity("Repository is empty", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({RepositoryNotExisting.class})
    private ResponseEntity<RepositoryNameDto> repositoryNotExisting(RepositoryNotExisting repositoryNotExisting) {
        repositoryNotExisting.printStackTrace();
        logger.error("REST CONTROLLER repositoryNotExisting()- result: " + repositoryNotExisting.getMessage());
        return new ResponseEntity("Repository not existing", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({Exception.class})
    private ResponseEntity<RepositoryNameDto> unExpectedError(Exception e){
        logger.error("REST CONTROLLER RepositoryControllers()- result: " + e.getMessage());
        return new ResponseEntity("Unexpected error", HttpStatus.NOT_FOUND);
    }
}
