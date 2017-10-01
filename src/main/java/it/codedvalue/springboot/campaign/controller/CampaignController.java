package it.codedvalue.springboot.campaign.controller;

import javax.annotation.Resource;

import it.codedvalue.springboot.campaign.domain.Campaign;
import it.codedvalue.springboot.campaign.service.CampaignService;
import java.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CampaignController {

    @Resource
    private CampaignService campaignService;

    @GetMapping("campaign/active")
    public Flux<Campaign> getActiveCampaign() {
        return campaignService.getActiveCampaignsOnReferenceDate(LocalDate.now());
    }

    @PostMapping("campaign/register")
    public Mono<ResponseEntity> registerForCampaign() {
        return Mono.just(new ResponseEntity(HttpStatus.OK));
    }

}
