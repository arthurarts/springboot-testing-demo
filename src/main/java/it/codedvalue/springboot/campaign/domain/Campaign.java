package it.codedvalue.springboot.campaign.domain;

import javax.persistence.Entity;

import java.time.LocalDate;
import java.util.Date;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import javax.persistence.Id;

@Entity
@Data
@Builder
public class Campaign {

    @Id
    private Long id;
    private String name;
    private String code;
    private LocalDate startDate;
    private LocalDate endDate;

    @Tolerate
    public Campaign () {

    }

}

