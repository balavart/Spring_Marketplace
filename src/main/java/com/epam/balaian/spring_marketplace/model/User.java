package com.epam.balaian.spring_marketplace.model;

import java.util.Collection;
import java.util.Collections;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Vardan Balaian
 * @created 13.02.2020
 * @since 1.8
 */
@Entity
@Table(name = "user", schema = "marketplace")
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "login_name", nullable = false)
  private String loginName;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "full_name", nullable = false)
  private String fullName;

  @Column(name = "city", nullable = false)
  private String city;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "phone_number", nullable = false)
  private String phoneNumber;

  @ManyToOne /*(fetch = FetchType.EAGER, cascade = CascadeType.ALL)*/
  @JoinColumn(name = "role_id", nullable = false)
  private Role role;

  public User() {}

  public User(
      String loginName,
      String password,
      String fullName,
      String city,
      String email,
      String phoneNumber,
      Role role) {
    this.loginName = loginName;
    this.password = password;
    this.fullName = fullName;
    this.city = city;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.role = role;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.singleton(getRole());
  }

  @Override
  public String getUsername() {
    return getLoginName();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
