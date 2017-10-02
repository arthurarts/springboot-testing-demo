package it.codedvalue.springboot.campaign.controller;

import javax.annotation.Resource;

import it.codedvalue.springboot.campaign.domain.Campaign;
import it.codedvalue.springboot.campaign.service.ReactiveCampaignService;
import java.time.LocalDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ReactiveCampaignController {

    @Resource
    private ReactiveCampaignService reactiveCampaignService;

    @GetMapping("campaign/{id}/r")
    public Mono<Campaign> getCampaignById(@PathVariable final Integer id) {
        return reactiveCampaignService.getCampaignById(id);
    }

    @GetMapping("campaign/active/r")
    public Flux<Campaign> getActiveCampaign() {
        return reactiveCampaignService.getActiveCampaignsOnReferenceDate(LocalDate.now());
    }

}
