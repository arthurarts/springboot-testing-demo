package it.codedvalue.springboot.campaign.controller;

import javax.annotation.Resource;

import it.codedvalue.springboot.campaign.domain.CampaignRegistration;
import it.codedvalue.springboot.campaign.service.CampaignRegistrationService;
import it.codedvalue.springboot.campaign.service.ReactiveCampaignRegistrationService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CampaignRegistrationController {

    @Resource
    private CampaignRegistrationService campaignRegistrationService;

    @GetMapping("campaign/registrations/all")
    public List<CampaignRegistration> getCampaignRegistrationById() {
        return  campaignRegistrationService.getAllCampaignRegistrations();
    }

    @GetMapping("campaign/registrations/all/{campaignId}")
    public List<CampaignRegistration> getCampaignRegistrationByCampaignId(@PathVariable final Integer campaignId) {
        return campaignRegistrationService.getCampaignRegistrationsByCampaignId(campaignId);
    }

    @PostMapping("campaign/register")
    public ResponseEntity register(@RequestBody final CampaignRegistration registration) {
        System.out.println("POST!");
        System.out.println(registration);
        campaignRegistrationService.saveRegistration(registration);
        return new ResponseEntity(HttpStatus.OK);
    }

}
