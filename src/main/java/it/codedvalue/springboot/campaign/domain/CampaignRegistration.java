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
    private Long id;
    private String firstName;
    private String lastName;
    private String iban;
    private String email;
    private Long campaignId;

    @Tolerate
    public CampaignRegistration() {

    }

}

