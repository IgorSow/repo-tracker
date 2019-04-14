package com.example.igor.sowinski.Allegro.Repo.domain.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfiguration {

    @Value("${allegro.repository.address.url}")
    private String serverAddress;

    @Bean
    RepositoryService service(){
        return new RepositoryService();
    }

    @Bean
    RepositoryInfrastructure infrastructure(){
        return new RepositoryInfrastructure(serverAddress);
    }

    @Bean
    RepositoryFacade repositoryFacade(RepositoryService repositoryService, RepositoryInfrastructure infrastructure){
        return new RepositoryFacade(repositoryService, infrastructure);
    }
}
