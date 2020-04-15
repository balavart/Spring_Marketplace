package com.epam.balaian.spring_marketplace.repositories;

import com.epam.balaian.spring_marketplace.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Vardan Balaian
 * @created 12.02.2020
 * @since 1.8
 */
@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {

  User findByLoginName(String loginName);
}
