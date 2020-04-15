package com.epam.balaian.spring_marketplace.repositories;

import com.epam.balaian.spring_marketplace.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Vardan Balaian
 * @created 2/13/2020
 * @since 1.8
 */
@Repository
@Transactional
public interface RoleRepository extends CrudRepository<Role, Integer> {

  Role findByTitle(String title);
}
