package com.epam.balaian.spring_marketplace.service;

import com.epam.balaian.spring_marketplace.model.Role;

/**
 * @author Vardan Balaian
 * @created 2/21/2020
 * @since 1.8
 */
public interface RoleService {

  Role findByTitle(String title);
}
