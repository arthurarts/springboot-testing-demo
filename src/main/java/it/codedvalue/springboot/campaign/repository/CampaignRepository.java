package it.codedvalue.springboot.campaign.repository;

import it.codedvalue.springboot.campaign.domain.Campaign;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

public interface CampaignRepository extends CrudRepository<Campaign, Integer> {

}
