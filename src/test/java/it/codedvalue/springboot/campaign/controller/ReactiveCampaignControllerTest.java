package it.codedvalue.springboot.campaign.controller;

import static org.mockito.BDDMockito.given;

import it.codedvalue.springboot.campaign.domain.Campaign;
import it.codedvalue.springboot.campaign.service.ReactiveCampaignService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ReactiveCampaignController.class)
public class ReactiveCampaignControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ReactiveCampaignService reactiveCampaignService;

    @Test
    public void testGetActiveCampaign() {
/*
        given(this.reactiveCampaignService.getActiveCampaignsOnReferenceDate("sboot"))
                .willReturn(Campaign.builder().code("caw").build());

        this.mvc.perform(get("/sboot/vehicle")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("Honda Civic"));
    }
*/


    }
}