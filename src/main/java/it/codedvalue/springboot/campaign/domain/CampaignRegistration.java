package it.codedvalue.springboot.campaign.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

@Entity
@Data
@Builder
public class CampaignRegistration {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Integer id;
    private String firstName;
    private String lastName;
    private String iban;
    private String email;
    private Integer campaignId;

    @Tolerate
    public CampaignRegistration() {

    }

}

