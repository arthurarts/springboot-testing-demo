package it.codedvalue.springboot.campaign.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import it.codedvalue.springboot.campaign.domain.Campaign;
import it.codedvalue.springboot.campaign.service.CampaignService;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


/**
 * Test 'classic blocking' controller.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CampaignController.class)
public class CampaignControllerTest {

    @MockBean
    private CampaignService campaignService;

    @Resource
     private MockMvc mockMvc;

    @Test
    public void testJsonCampaign1() throws Exception {

        Campaign campaign = Campaign.builder()
                .id(1)
                .name("Click and Win")
                .code("CAW")
                .startDate(LocalDate.of(2017, Month.SEPTEMBER, 30))
                .endDate(LocalDate.of(2017, Month.OCTOBER, 31))
                .build();


        Mockito.doReturn(campaign).when(campaignService).getCampaignById(1);

        mockMvc.perform(get("/campaign/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("{\"id\":1,\"name\":\"Click and Win\",\"code\":\"CAW\",\"startDate\":[2017,9,30],\"endDate\":[2017,10,31]}"));

    }

}
