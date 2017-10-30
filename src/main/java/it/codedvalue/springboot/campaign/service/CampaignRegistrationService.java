package it.codedvalue.springboot.campaign.service;

import it.codedvalue.springboot.campaign.domain.CampaignRegistration;
import it.codedvalue.springboot.campaign.repository.CampaignRegistrationRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CampaignRegistrationService {

    private CampaignRegistrationRepository campaignRegistrationRepository;

    public CampaignRegistrationService(CampaignRegistrationRepository campaignRegistrationRepository) {
        this.campaignRegistrationRepository = campaignRegistrationRepository;

    }

    public CampaignRegistration getCampaignRegistrationById(final Integer id) {
        return campaignRegistrationRepository.findById(id).get();
    }

    public void saveRegistration(final CampaignRegistration registration) {
        campaignRegistrationRepository.save(registration);
    }

    public List<CampaignRegistration> getAllCampaignRegistrations() {
        Stream<CampaignRegistration> stream = StreamSupport.stream(campaignRegistrationRepository.findAll().spliterator(), false);
        return stream.collect(Collectors.toList());
    }

    public List<CampaignRegistration> getCampaignRegistrationsByCampaignId(final Integer campaignId) {

        Stream<CampaignRegistration> stream = StreamSupport.stream(campaignRegistrationRepository.findAll().spliterator(), false);

        return stream
                .filter(
                        registration -> registration.getCampaignId()
                                .equals(campaignId)
                ).collect(Collectors.toList());
    }

}
