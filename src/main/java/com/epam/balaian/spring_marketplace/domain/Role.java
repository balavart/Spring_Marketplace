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
public class Role {

  @Id
  @NonNull
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int roleId;

  @Basic
  @NonNull
//  @DecimalMin(value = "20")
  private String roleTitle;

  @OneToMany(mappedBy = "roleByRoleIdFk", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Collection<User> usersByRoleId;

  public Role() {
  }

  public int getRoleId() {
    return roleId;
  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

  public String getRoleTitle() {
    return roleTitle;
  }

  public void setRoleTitle(String roleTitle) {
    this.roleTitle = roleTitle;
  }

  public Collection<User> getUsersByRoleId() {
    return usersByRoleId;
  }

  public void setUsersByRoleId(Collection<User> usersByRoleId) {
    this.usersByRoleId = usersByRoleId;
  }

/*  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Role role = (Role) o;
    return roleId == role.roleId && Objects.equals(roleTitle, role.roleTitle);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roleId, roleTitle);
  }*/
}
