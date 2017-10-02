package it.codedvalue.springboot.campaign.repository;

import it.codedvalue.springboot.campaign.domain.Campaign;
import it.codedvalue.springboot.campaign.domain.CampaignRegistration;
import org.springframework.data.repository.CrudRepository;

public interface CampaignRegistrationRepository extends CrudRepository<CampaignRegistration, Long> {

}
