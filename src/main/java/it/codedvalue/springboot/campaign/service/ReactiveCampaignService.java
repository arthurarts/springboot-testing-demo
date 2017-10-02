package it.codedvalue.springboot.campaign.service;

import it.codedvalue.springboot.campaign.domain.Campaign;
import it.codedvalue.springboot.campaign.repository.CampaignRepository;
import java.time.LocalDate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactiveCampaignService {

    private CampaignRepository campaignRepository;

    public ReactiveCampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;

    }

    public Mono<Campaign> getCampaignById(Long id) {
        return Mono.just(campaignRepository.findById(id).get());
    }


    public Flux<Campaign> getActiveCampaignsOnReferenceDate(final LocalDate referenceDate) {

        campaignRepository.findAll().forEach(System.out::print);

        return Flux.fromIterable(campaignRepository.findAll())
                .filter(c -> referenceDate.isAfter(c.getStartDate()) && referenceDate.isBefore(c.getEndDate()));
    }

}
