package com.epam.balaian.spring_marketplace.service;

import com.epam.balaian.spring_marketplace.model.Role;
import com.epam.balaian.spring_marketplace.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Vardan Balaian
 * @created 2/21/2020
 * @since 1.8
 */
@Service
public class RoleServiceImpl implements RoleService {

  private final RoleRepository roleRepository;

  @Autowired
  public RoleServiceImpl(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
  public Role findByTitle(String title) {
    return roleRepository.findByTitle(title);
  }
}
