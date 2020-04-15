package com.epam.balaian.spring_marketplace.domain;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import org.springframework.lang.NonNull;

/**
 * @author Vardan Balaian
 * @created 2/13/2020
 * @since 1.8
 */
@Entity
public class Product {

  @Id
  @NonNull
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int productId;

  @Basic
  @NonNull
  @DecimalMin(value = "20")
  private String productTitle;

  @Basic
  @NonNull
  @DecimalMin(value = "150")
  private String description;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @NonNull
  private User userByProductOwnerIdFk;

  @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @NonNull
  private Bidding biddingByBiddingIdFk;

  public Product() {
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String getProductTitle() {
    return productTitle;
  }

  public void setProductTitle(String productTitle) {
    this.productTitle = productTitle;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public User getUserByProductOwnerIdFk() {
    return userByProductOwnerIdFk;
  }

  public void setUserByProductOwnerIdFk(User userByProductOwnerIdFk) {
    this.userByProductOwnerIdFk = userByProductOwnerIdFk;
  }

  public Bidding getBiddingByBiddingIdFk() {
    return biddingByBiddingIdFk;
  }

  public void setBiddingByBiddingIdFk(Bidding biddingByBiddingIdFk) {
    this.biddingByBiddingIdFk = biddingByBiddingIdFk;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return productId == product.productId
        && Objects.equals(productTitle, product.productTitle)
        && Objects.equals(description, product.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, productTitle, description);
  }
}
