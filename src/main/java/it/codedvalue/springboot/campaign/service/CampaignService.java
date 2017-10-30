package it.codedvalue.springboot.campaign.service;

import it.codedvalue.springboot.campaign.domain.Campaign;
import it.codedvalue.springboot.campaign.repository.CampaignRepository;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CampaignService {

    private CampaignRepository campaignRepository;

    public CampaignService(final CampaignRepository campaignRepository) {
        this.campaignRepository = campaignRepository;

    }

    public Campaign getCampaignById(final Integer id) {
        return campaignRepository.findById(id).get();
    }


    public List<Campaign> getActiveCampaignsOnReferenceDate(final LocalDate referenceDate) {

        Stream<Campaign> stream = StreamSupport.stream(campaignRepository.findAll().spliterator(), false);

        return stream
                .filter(c -> referenceDate.isAfter(c.getStartDate()) && referenceDate.isBefore(c.getEndDate()))
                .collect(Collectors.toList());
    }

}
