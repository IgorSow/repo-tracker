package com.example.igor.sowinski.allegro.repo.api.controllers;

import com.example.igor.sowinski.allegro.repo.AllegroRepoApplication;
import com.example.igor.sowinski.allegro.repo.api.dto.RepositoryNameDto;
import com.example.igor.sowinski.allegro.repo.domain.model.RepositoryFacadeTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RepositoryControllersTest {

    @Value("${server.port.inTest}")
    private String portServer;

    private String ENDPOINT = "/allegro-last-updated-repository";

    private Logger logger = LoggerFactory.getLogger(RepositoryControllersTest.class);

    @Before
    public void runApplication() {
        AllegroRepoApplication.main(new String[]{});
    }

    @Test
    public void shouldReturnEntityFromServer() {
        //given
        TestRestTemplate testRestTemplate = new TestRestTemplate();
        //when
        ResponseEntity<RepositoryNameDto> entity = testRestTemplate.getForEntity("http://localhost:" + portServer + ENDPOINT, RepositoryNameDto.class);
        RepositoryNameDto repositoryNameDto = entity.getBody();

        //then
        logger.info("TEST shouldReturnEntityFromServer()- result: " + repositoryNameDto.getNameRepository());
        Assert.assertNotNull(repositoryNameDto.getNameRepository());
    }
}