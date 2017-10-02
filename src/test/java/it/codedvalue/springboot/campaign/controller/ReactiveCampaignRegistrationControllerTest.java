package it.codedvalue.springboot.campaign.controller;

import javax.annotation.Resource;

import it.codedvalue.springboot.campaign.domain.CampaignRegistration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ReactiveCampaignRegistrationControllerTest {

    @Resource
    private final WebTestClient clientIntegration = WebTestClient
            .bindToServer().baseUrl("http://localhost:8080")
            .build();

    @Before
    public void setUp() {

        clientIntegration.get().uri("campaign/registrations/all/2/r")
                .exchange()
                .expectBody()
                .json("[]");
    }

    @Test
    public void testRegistrationSuccesful() throws Exception {


        // Given
        CampaignRegistration registration = CampaignRegistration.builder()
                .id(1)
                .email("darth.vader@deathstar.org")
                .campaignId(2)
                .firstName("Darth")
                .lastName("Vader")
                .iban("NL70ING0076544145")
                .build();

        // When
        clientIntegration.post().uri("/campaign/register/r")
                .body(BodyInserters.fromObject(registration))
                .exchange()
                .expectStatus().isOk();

        // Then
        clientIntegration.get().uri("campaign/registrations/all/2/r")
                .exchange()
                .expectBody()
                .json("[" +
                        "{" +
                        "firstName: \"Darth\"," +
                        "lastName: \"Vader\"," +
                        "iban: \"NL70ING0076544145\"," +
                        "email: \"darth.vader@deathstar.org\"," +
                        "campaignId: 2" +
                        "}" +
                        "]");
    }





}
