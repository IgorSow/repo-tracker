package com.example.igor.sowinski.allegro.repo.domain.model;

import com.example.igor.sowinski.allegro.repo.api.dto.RepositoryNameDto;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class RepositoryFacadeTest {
    private Logger logger = LoggerFactory.getLogger(RepositoryFacadeTest.class);

    @Test
    public void shouldReturnLatestRepositoryNameDto() {
        //given
        RepositoryService repositoryService = new RepositoryService();
        RepositoryInfrastructure infrastructure = new RepositoryInfrastructure("https://api.github.com/users/IgorSow/repos");
        RepositoryFacade repositoryFacade = new RepositoryFacade(repositoryService, infrastructure);

        List<Repository> repositoryList = infrastructure.getRepositoryList();
        List<Repository> orderListByUpdateDate = repositoryService.orderListByUpdateDate(repositoryList);
        Repository latestRepo = repositoryService.getLatestRepo(orderListByUpdateDate);

        //when
        RepositoryNameDto latestRepoDto = repositoryFacade.getLatestRepo();

        //then
        logger.info("TEST shouldReturnLatestRepositoryNameDto()- result: " + latestRepo.getName());
        logger.info("TEST shouldReturnLatestRepositoryNameDto()- result: " + latestRepoDto.getNameRepository());
        Assert.assertEquals(latestRepo.getName(), latestRepoDto.getNameRepository());
}
}