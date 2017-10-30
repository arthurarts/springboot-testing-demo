package it.codedvalue.springboot.campaign.controller;

import it.codedvalue.springboot.campaign.domain.SavingsTransactionEvent;
import java.math.BigDecimal;
import java.time.Duration;
import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

/**
 * @author Arthur Arts
 */
@RestController
public class SavingsTransactionsController {

    @GetMapping("/savingstransactions/{id}")
    Mono<SavingsTransactionEvent> eventById(@PathVariable Long id) {
        return Mono.just(new SavingsTransactionEvent(id, BigDecimal.valueOf((new Random()).nextInt((1500 - 0) + 1) + 0 ), new Date()));
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE, value = "/savingstransactions")
    Flux<SavingsTransactionEvent> transactionEvents() {
        Flux<SavingsTransactionEvent> savingsTransactionsFlux =
                Flux.fromStream(
                        Stream.generate(
                                () -> new SavingsTransactionEvent(System.currentTimeMillis(), BigDecimal.valueOf(
                                        (new Random()).nextInt((1500 - 0) + 1) + 0), new Date())
                        ));

        Flux<Long> durationsFlux = Flux.interval(Duration.ofMillis(10));

        return Flux.zip(savingsTransactionsFlux, durationsFlux).map(Tuple2::getT1); // http://rxmarbles.com/#zip
    }
}
