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
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Vardan Balaian
 * @created 13.02.2020
 * @since 1.8
 */
@Entity
@Table(name = "user", schema = "marketplace")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "login_name", nullable = false)
  @NonNull
  private String loginName;

  @Column(name = "password", nullable = false)
  @NonNull
  private String password;

  @Column(name = "full_name", nullable = false)
  @NonNull
  private String fullName;

  @Column(name = "city", nullable = false)
  @NonNull
  private String city;

  @Column(name = "email", nullable = false)
  @NonNull
  private String email;

  @Column(name = "phone_number", nullable = false)
  @NonNull
  private String phoneNumber;

  @ManyToOne
  @JoinColumn(name = "role_id", nullable = false)
  @NonNull
  private Role role;

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
