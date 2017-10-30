package it.codedvalue.springboot.campaign.controller;

import javax.annotation.Resource;

import it.codedvalue.springboot.campaign.domain.SavingsTransactionEvent;
import java.math.BigDecimal;
import org.hibernate.loader.plan.spi.BidirectionalEntityReference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.FluxExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

/**
 * @author Arthur Arts
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SavingsTransactionsControllerTest {

    @Resource
    private final WebTestClient client = WebTestClient
            .bindToController(new SavingsTransactionsController())
            .build();

    @Test
    public void testSavingsTransactionsById_JsonTest() {
        client.get().uri("/savingstransactions/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody().jsonPath("id").isEqualTo(1);
    }


    @Test
    public void testSavingsTransactionsById_BodyTest() {
        client.get().uri("/savingstransactions/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody(SavingsTransactionEvent.class)
//        .consumeWith( // anybody an idea?
//                result -> assertThat(
//                    result.getResponseBody().getId())
//                .isEqualTo(1L)
//        )
        ;
    }


    @Test
    public void testSavingsTransactions() {

        FluxExchangeResult<SavingsTransactionEvent> result = this.client.get()
                .uri("/savingstransactions")
                .accept()
                .exchange()
                .expectStatus().isOk()
                .returnResult(SavingsTransactionEvent.class);

        StepVerifier.create(result.getResponseBody())
                .expectNextCount(100)
                .consumeNextWith(transactionEvent -> assertThat(
                        transactionEvent.getAmount())
                        .isBetween(BigDecimal.ONE, BigDecimal.valueOf(150)))
                .thenCancel()
                .verify();
    }


    @Test
    public void testSavingsTransactionsJson() {

        FluxExchangeResult<SavingsTransactionEvent> result = this.client.get()
                .uri("/savingstransactions")
                .accept()
                .exchange()
                .expectStatus().isOk()
                .returnResult(SavingsTransactionEvent.class);

        StepVerifier.create(result.getResponseBody())
                .expectNextCount(500)
                .consumeNextWith(transactionEvent -> assertThat(
                        transactionEvent.getAmount())
                        .isBetween(BigDecimal.ONE, BigDecimal.valueOf(1500)))
                .thenCancel()
                .verify();
    }


}