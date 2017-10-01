package it.codedvalue.springboot.campaign.service;

import it.codedvalue.springboot.campaign.domain.Campaign;
import it.codedvalue.springboot.campaign.repository.CampaignRepository;
import java.time.LocalDate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class CampaignService {

    private CampaignRepository campaignRepository;

    public CampaignService(CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;

    }

    public Flux<Campaign> getActiveCampaignsOnReferenceDate(final LocalDate referenceDate) {

        return Flux.fromIterable(campaignRepository.findAll())
                .filter(c -> referenceDate.isAfter(c.getStartDate()) && referenceDate.isBefore(c.getEndDate()));
    }

}