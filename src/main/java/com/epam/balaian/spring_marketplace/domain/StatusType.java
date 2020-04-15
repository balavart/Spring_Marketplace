package com.epam.balaian.spring_marketplace.domain;

import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import org.springframework.lang.NonNull;

/**
 * @author Vardan Balaian
 * @created 2/13/2020
 * @since 1.8
 */
@Entity
public class StatusType {

  @Id
  @NonNull
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int statusId;

  @Basic
  @NonNull
  @DecimalMin(value = "20")
  private String statusTitle;

  @OneToMany(mappedBy = "statusTypeByStatusIdFk", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Collection<Bidding> biddingsByStatusId;

  public StatusType() {
  }

  public int getStatusId() {
    return statusId;
  }

  public void setStatusId(int statusId) {
    this.statusId = statusId;
  }

  public String getStatusTitle() {
    return statusTitle;
  }

  public void setStatusTitle(String statusTitle) {
    this.statusTitle = statusTitle;
  }

  public Collection<Bidding> getBiddingsByStatusId() {
    return biddingsByStatusId;
  }

  public void setBiddingsByStatusId(Collection<Bidding> biddingsByStatusId) {
    this.biddingsByStatusId = biddingsByStatusId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StatusType that = (StatusType) o;
    return statusId == that.statusId && Objects.equals(statusTitle, that.statusTitle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statusId, statusTitle);
  }
}
