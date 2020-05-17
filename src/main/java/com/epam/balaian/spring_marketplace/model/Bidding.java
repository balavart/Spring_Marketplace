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
import org.springframework.lang.Nullable;

/**
 * @author Vardan Balaian
 * @created 13.02.2020
 * @since 1.8
 */
@Entity
@Table(name = "bidding", schema = "marketplace")
public class Bidding {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "starting_price", nullable = false)
  private Double startingPrice;

  @Column(name = "offer_end_date", nullable = false)
  private Date offerEndDate;

  @Column(name = "best_offer")
  private Double bestOffer;

  @ManyToOne
  @JoinColumn(name = "supposed_bidder_id")
  private User supposedBidder;

  @ManyToOne
  @JoinColumn(name = "status_id", nullable = false)
  private StatusType status;

  public Bidding() {}

  public Bidding(Double startingPrice, Date offerEndDate, Double bestOffer, StatusType status) {
    this.startingPrice = startingPrice;
    this.offerEndDate = offerEndDate;
    this.bestOffer = bestOffer;
    this.status = status;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Double getStartingPrice() {
    return startingPrice;
  }

  public void setStartingPrice(Double startingPrice) {
    this.startingPrice = startingPrice;
  }

  public Date getOfferEndDate() {
    return offerEndDate;
  }

  public void setOfferEndDate(Date offerEndDate) {
    this.offerEndDate = offerEndDate;
  }

  @Nullable
  public Double getBestOffer() {
    return bestOffer;
  }

  public void setBestOffer(@Nullable Double bestOffer) {
    this.bestOffer = bestOffer;
  }

  public User getSupposedBidder() {
    return supposedBidder;
  }

  public void setSupposedBidder(User supposedBidder) {
    this.supposedBidder = supposedBidder;
  }

  public StatusType getStatus() {
    return status;
  }

  public void setStatus(StatusType status) {
    this.status = status;
  }
}
