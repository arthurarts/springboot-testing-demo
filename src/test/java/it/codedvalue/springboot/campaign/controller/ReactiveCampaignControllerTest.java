package it.codedvalue.springboot.campaign.controller;

import javax.annotation.Resource;

import it.codedvalue.springboot.campaign.domain.Campaign;
import it.codedvalue.springboot.campaign.service.ReactiveCampaignService;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ReactiveCampaignControllerTest {


    @MockBean
    private ReactiveCampaignService reactiveCampaignService;

    @Resource
    private final WebTestClient clientUnitTest = WebTestClient
            .bindToController(new ReactiveCampaignController(reactiveCampaignService))
            .build();

    @Test
    public void testJsonCampaign1() throws Exception {

        Campaign campaign = Campaign.builder()
                .id(1)
                .name("Click and Win")
                .code("CAW")
                .startDate(LocalDate.of(2017, Month.SEPTEMBER, 30))
                .endDate(LocalDate.of(2017, Month.OCTOBER, 31))
                .build();


        Mockito.doReturn(Mono.just(campaign)).when(reactiveCampaignService).getCampaignById(1);

        clientUnitTest.get().uri("/campaign/1/r")
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .expectBody()
                .json("{\"id\":1,\"name\":\"Click and Win\",\"code\":\"CAW\",\"startDate\":[2017,9,30],\"endDate\":[2017,10,31]}");

    }






}
