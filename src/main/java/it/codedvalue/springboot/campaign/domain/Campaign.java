package it.codedvalue.springboot.campaign.domain;

import java.time.LocalDate;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Campaign {
    private String name;
    private String code;
    private LocalDate startDate;
    private LocalDate endDate;
}

