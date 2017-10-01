package it.codedvalue.springboot.campaign.service;

import javax.annotation.Resource;

import it.codedvalue.springboot.campaign.domain.Campaign;
import it.codedvalue.springboot.campaign.repository.CampaignRepository;
import java.time.LocalDate;
import java.time.Month;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@Service
public class CampaignService {

    private CampaignRepository campaignRepository;

    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;

    }


    public Flux<Campaign> getActiveCampaignsOnReferenceDate(final LocalDate referenceDate) {


/*
        campaignRepository.findAll();

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
*/
        
        return Flux.fromIterable(campaignRepository.findAll())
                .filter(c -> referenceDate.isAfter(c.getStartDate()) && referenceDate.isBefore(c.getEndDate()));
    }

}
