package it.codedvalue.springboot.campaign.controller;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ReactiveCampaignControllerTest {

    @Resource
    private final WebTestClient clientIntegration = WebTestClient
            .bindToServer().baseUrl("http://localhost:8080")
            .build();

    @Test
    public void testJsonCampaign1() throws Exception {
        clientIntegration.get().uri("/campaign/1/r")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBody()
                .json("{\"id\":1,\"name\":\"Cick and Win\",\"code\":\"CAW\",\"startDate\":[2017,9,30],\"endDate\":[2017,10,31]}");

    }


}
