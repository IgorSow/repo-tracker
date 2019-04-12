package com.example.igor.sowinski.Allegro.Repo.domain.model;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfiguration {


    @Bean
    RepositoryService repositoryService (){
        return new RepositoryService();
    }

    @Bean
    RepositoryFacade repositoryFacade(RepositoryService repositoryService){
        return new RepositoryFacade(repositoryService);
    }


}
