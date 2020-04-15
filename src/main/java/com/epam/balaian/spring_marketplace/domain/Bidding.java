package com.epam.balaian.spring_marketplace.domain;

import java.sql.Date;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMin;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * @author Vardan Balaian
 * @created 2/13/2020
 * @since 1.8
 */
@Entity
public class Bidding {

  @Id
  @NonNull
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int biddingId;

  @Basic
  @NonNull
  @DecimalMin(value = "1")
  private double startingPrice;

  @Basic
  @NonNull
  private Date offerEndDate;

  @Basic
  @Nullable
  @DecimalMin(value = "1")
  private Double bestOffer;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private User userBySupposedBidderIdFk;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @NonNull
  private StatusType statusTypeByStatusIdFk;

  @OneToMany(mappedBy = "biddingByBiddingIdFk", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Collection<Product> productsByBiddingId;

  public Bidding() {
  }

  public int getBiddingId() {
    return biddingId;
  }

  public void setBiddingId(int biddingId) {
    this.biddingId = biddingId;
  }

  public double getStartingPrice() {
    return startingPrice;
  }

  public void setStartingPrice(double startingPrice) {
    this.startingPrice = startingPrice;
  }

  public Date getOfferEndDate() {
    return offerEndDate;
  }

  public void setOfferEndDate(Date offerEndDate) {
    this.offerEndDate = offerEndDate;
  }

  public Double getBestOffer() {
    return bestOffer;
  }

  public void setBestOffer(Double bestOffer) {
    this.bestOffer = bestOffer;
  }

  public User getUserBySupposedBidderIdFk() {
    return userBySupposedBidderIdFk;
  }

  public void setUserBySupposedBidderIdFk(
      User userBySupposedBidderIdFk) {
    this.userBySupposedBidderIdFk = userBySupposedBidderIdFk;
  }

  public StatusType getStatusTypeByStatusIdFk() {
    return statusTypeByStatusIdFk;
  }

  public void setStatusTypeByStatusIdFk(
      StatusType statusTypeByStatusIdFk) {
    this.statusTypeByStatusIdFk = statusTypeByStatusIdFk;
  }

  public Collection<Product> getProductsByBiddingId() {
    return productsByBiddingId;
  }

  public void setProductsByBiddingId(
      Collection<Product> productsByBiddingId) {
    this.productsByBiddingId = productsByBiddingId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Bidding bidding = (Bidding) o;
    return biddingId == bidding.biddingId &&
        Double.compare(bidding.startingPrice, startingPrice) == 0 &&
        Objects.equals(offerEndDate, bidding.offerEndDate) &&
        Objects.equals(bestOffer, bidding.bestOffer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(biddingId, startingPrice, offerEndDate, bestOffer);
  }
}
