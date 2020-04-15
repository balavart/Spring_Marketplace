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
import javax.persistence.ManyToOne;
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
public class User {

  @Id
  @NonNull
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int userId;

  @Basic @NonNull
  //  @DecimalMin(value = "20")
  private String loginName;

  @Basic @NonNull
  //  @DecimalMin(value = "20")
  private String password;

  @Basic @NonNull
  //  @DecimalMin(value = "40")
  private String fullName;

  @Basic @NonNull
  //  @DecimalMin(value = "30")
  private String city;

  @Basic @NonNull
  //  @DecimalMin(value = "40")
  private String email;

  @Basic @NonNull
  //  @DecimalMin(value = "12")
  private String phoneNumber;

  @OneToMany(mappedBy = "userBySupposedBidderIdFk" /*,
      fetch = FetchType.EAGER,
      cascade = CascadeType.ALL*/)
  private Collection<Bidding> biddingsByUserId;

  @OneToMany(mappedBy = "userByProductOwnerIdFk" /*,
      fetch = FetchType.EAGER,
      cascade = CascadeType.ALL*/)
  private Collection<Product> productsByUserId;

//  @Basic
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @NonNull
  private Role roleByRoleIdFk;

  public User() {}

  public User(
      String loginName,
      String password,
      String fullName,
      String city,
      String email,
      String phoneNumber,
      Role roleByRoleIdFk) {
    this.loginName = loginName;
    this.password = password;
    this.fullName = fullName;
    this.city = city;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.roleByRoleIdFk = roleByRoleIdFk;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Collection<Bidding> getBiddingsByUserId() {
    return biddingsByUserId;
  }

  public void setBiddingsByUserId(Collection<Bidding> biddingsByUserId) {
    this.biddingsByUserId = biddingsByUserId;
  }

  public Collection<Product> getProductsByUserId() {
    return productsByUserId;
  }

  public void setProductsByUserId(Collection<Product> productsByUserId) {
    this.productsByUserId = productsByUserId;
  }

  public Role getRoleByRoleIdFk() {
    return roleByRoleIdFk;
  }

  public void setRoleByRoleIdFk(Role roleByRoleIdFk) {
    this.roleByRoleIdFk = roleByRoleIdFk;
  }

/*  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return userId == user.userId
//        && roleByRoleIdFk == user.roleByRoleIdFk
        && Objects.equals(loginName, user.loginName)
        && Objects.equals(password, user.password)
        && Objects.equals(fullName, user.fullName)
        && Objects.equals(city, user.city)
        && Objects.equals(email, user.email)
        && Objects.equals(phoneNumber, user.phoneNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        userId, loginName, password, fullName, city, email, phoneNumber, roleByRoleIdFk);
  }*/
}
