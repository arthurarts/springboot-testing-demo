package it.codedvalue.springboot.campaign.controller;

import javax.annotation.Resource;

import it.codedvalue.springboot.campaign.domain.Campaign;
import it.codedvalue.springboot.campaign.domain.CampaignRegistration;
import it.codedvalue.springboot.campaign.service.ReactiveCampaignRegistrationService;
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
public class ReactiveCampaignRegistrationController {

    @Resource
    private ReactiveCampaignRegistrationService reactiveCampaignRegistrationService;

    @GetMapping("campaign/registrations/all/r")
    public Flux<CampaignRegistration> getCampaignRegistrationById() {
        return reactiveCampaignRegistrationService.getAllCampaignRegistrations();
    }

    @GetMapping("campaign/registrations/all/{campaignId}/r")
    public Flux<CampaignRegistration> getCampaignRegistrationByCampaignId(@PathVariable final Integer campaignId) {
        return reactiveCampaignRegistrationService.getCampaignRegistrationsByCampaignId(campaignId);
    }

    @PostMapping("campaign/register/r")
    public Mono<ResponseEntity> register(@RequestBody final CampaignRegistration registration) {
        System.out.println("POST!");
        System.out.println(registration);
        reactiveCampaignRegistrationService.saveRegistration(registration);
        return Mono.just(new ResponseEntity(HttpStatus.OK));
    }

}
