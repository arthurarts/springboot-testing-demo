package it.codedvalue.springboot.campaign.controller;

import it.codedvalue.springboot.campaign.domain.Campaign;
import it.codedvalue.springboot.campaign.service.CampaignService;
import it.codedvalue.springboot.campaign.service.ReactiveCampaignService;
import java.time.LocalDate;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class CampaignController {

    private CampaignService campaignService;

    /** no autowiring annotation needed :-) */
    public CampaignController(final CampaignService campaignService) {
        this.campaignService = campaignService;
    }

    @GetMapping("campaign/{id}")
    public Campaign getCampaignById(@PathVariable final Integer id) {
        return campaignService.getCampaignById(id);
    }

    @GetMapping("campaign/active")
    public List<Campaign> getActiveCampaign() {
        return campaignService.getActiveCampaignsOnReferenceDate(LocalDate.now());
    }

}
