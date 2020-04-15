package com.epam.balaian.spring_marketplace.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Vardan Balaian
 * @created 13.02.2020
 * @since 1.8
 */
@Entity
@Table(name = "product", schema = "marketplace")
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "description", nullable = false)
  private String description;

  @ManyToOne
  @JoinColumn(name = "product_owner_id", nullable = false)
  private User productOwner;

  @ManyToOne
  @JoinColumn(name = "bidding_id", nullable = false)
  private Bidding productBidding;

  public Product() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public User getProductOwner() {
    return productOwner;
  }

  public void setProductOwner(User productOwner) {
    this.productOwner = productOwner;
  }

  public Bidding getProductBidding() {
    return productBidding;
  }

  public void setProductBidding(Bidding productBidding) {
    this.productBidding = productBidding;
  }
}
