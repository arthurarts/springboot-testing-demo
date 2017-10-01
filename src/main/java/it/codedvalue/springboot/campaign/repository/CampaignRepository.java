package it.codedvalue.springboot.campaign.repository;

import it.codedvalue.springboot.campaign.domain.Campaign;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class CampaignRepository {

    public Flux<Campaign> getActiveCampaignsOnReferenceDate(final LocalDate referenceDate) {

        Campaign campaign1 = Campaign.builder()
                .name("click and win")
                .code("caw")
                .startDate(LocalDate.of(2017, Month.SEPTEMBER, 30))
                .endDate(LocalDate.of(2017, Month.OCTOBER, 3))
                .build();

        Campaign campaign2 = Campaign.builder()
                .name("click and win")
                .code("caw")
                .startDate(LocalDate.of(2017, Month.SEPTEMBER, 30))
                .endDate(LocalDate.of(2017, Month.NOVEMBER, 1))
                .build();

        Campaign campaign3 = Campaign.builder()
                .name("click and win")
                .code("caw")
                .startDate(LocalDate.of(2017, Month.NOVEMBER, 1))
                .endDate(LocalDate.of(2017, Month.NOVEMBER, 30))
                .build();


        return Flux
                .just(campaign1, campaign2, campaign3)
                .filter(c -> referenceDate.isAfter(c.getStartDate()) && referenceDate.isBefore(c.getEndDate()));
    }

}
