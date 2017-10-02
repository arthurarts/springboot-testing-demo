package it.codedvalue.springboot.campaign.domain.json;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.Resource;

import it.codedvalue.springboot.campaign.domain.Campaign;
import java.time.LocalDate;
import java.time.Month;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit4.SpringRunner;

@JsonTest
@RunWith(SpringRunner.class)
public class MyJsonTest {

    @Resource
    private JacksonTester<Campaign> json;

    private Campaign campaignToSerialize = Campaign.builder()
            .id(1)
            .code("CAW")
            .name("click and win")
            .startDate(LocalDate.of(2017, Month.SEPTEMBER, 30))
            .endDate(LocalDate.of(2017, Month.NOVEMBER, 30))
            .build();

    private final String CAMPAIGN_JSON = "{\"id\":1,\"name\":\"click and win\",\"code\":\"CAW\",\"startDate\":[2017,9,30]," +
            "\"endDate\":[2017,11,30]}";

    @Test
    public void testSerialize() throws Exception {

        assertThat(this.json.write(campaignToSerialize)).isEqualToJson(CAMPAIGN_JSON);

        // Or use JSON path based assertions
        assertThat(this.json.write(campaignToSerialize)).hasJsonPathStringValue("@.code");
        assertThat(this.json.write(campaignToSerialize)).extractingJsonPathStringValue("@.code")
                .isEqualTo("CAW");
    }

    @Test
    public void testDeserialize() throws Exception {
        assertThat(this.json.parse(CAMPAIGN_JSON))
                .isEqualTo(campaignToSerialize);
        assertThat(this.json.parseObject(CAMPAIGN_JSON).getCode()).isEqualTo("CAW");
    }

}