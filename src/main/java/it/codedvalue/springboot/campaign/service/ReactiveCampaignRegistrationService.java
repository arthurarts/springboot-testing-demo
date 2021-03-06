package it.codedvalue.springboot.campaign.service;

import it.codedvalue.springboot.campaign.domain.Campaign;
import it.codedvalue.springboot.campaign.domain.CampaignRegistration;
import it.codedvalue.springboot.campaign.repository.CampaignRegistrationRepository;
import it.codedvalue.springboot.campaign.repository.CampaignRepository;
import java.time.LocalDate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactiveCampaignRegistrationService {

    private CampaignRegistrationRepository campaignRegistrationRepository;

    public ReactiveCampaignRegistrationService(CampaignRegistrationRepository campaignRegistrationRepository) {
        this.campaignRegistrationRepository = campaignRegistrationRepository;

    }

    public Mono<CampaignRegistration> getCampaignRegistrationById(final Integer id) {
        return Mono.just(campaignRegistrationRepository.findById(id).get());
    }


    public Mono<Void> saveRegistration(final CampaignRegistration registration) {
        campaignRegistrationRepository.save(registration);
        return Mono.empty();
    }

    public Flux<CampaignRegistration> getAllCampaignRegistrations() {
        return Flux.fromIterable(campaignRegistrationRepository.findAll());
    }

    public Flux<CampaignRegistration> getCampaignRegistrationsByCampaignId(final Integer campaignId) {

        return Flux.fromIterable(
                campaignRegistrationRepository.findAll())
                .filter(
                        registration -> registration.getCampaignId()
                                .equals(campaignId)
                );
    }

}
