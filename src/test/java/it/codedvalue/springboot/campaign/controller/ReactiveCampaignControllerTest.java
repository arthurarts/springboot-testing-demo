package it.codedvalue.springboot.campaign.controller;

import static org.mockito.BDDMockito.given;

import it.codedvalue.springboot.campaign.domain.Campaign;
import it.codedvalue.springboot.campaign.service.ReactiveCampaignService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ReactiveCampaignControllerTest {

    @Autowired
    private final WebTestClient client = WebTestClient
            .bindToServer().baseUrl("http://localhost:8080")
            .build();

    @Test
    public void testJsonCampaign1() throws Exception {
        client.get().uri("/campaign/1/r")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBody()
                .json("{\"id\":1,\"name\":\"Cick and Win\",\"code\":\"CAW\",\"startDate\":[2017,9,30],\"endDate\":[2017,10,31]}");
    }

}
