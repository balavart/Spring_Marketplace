package com.epam.balaian.spring_marketplace.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;

/**
 * @author Vardan Balaian
 * @created 13.02.2020
 * @since 1.8
 */
@Entity
@Table(name = "bidding", schema = "marketplace")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Bidding {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "starting_price", nullable = false)
  @NonNull
  private Double startingPrice;

  @Column(name = "offer_end_date", nullable = false)
  @NonNull
  private Date offerEndDate;

  @Column(name = "best_offer")
  @Nullable
  @NonNull
  private Double bestOffer;

  @ManyToOne
  @JoinColumn(name = "supposed_bidder_id")
  private User supposedBidder;

  @ManyToOne
  @JoinColumn(name = "status_id", nullable = false)
  @NonNull
  private StatusType status;
}
