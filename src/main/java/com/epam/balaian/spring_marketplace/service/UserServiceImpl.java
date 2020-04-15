package com.epam.balaian.spring_marketplace.service;

import com.epam.balaian.spring_marketplace.model.User;
import com.epam.balaian.spring_marketplace.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Vardan Balaian
 * @created 2/21/2020
 * @since 1.8
 */
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User findByLoginName(String loginName) {
    return userRepository.findByLoginName(loginName);
  }

  @Override
  public void saveUser(User newUser) {
    userRepository.save(newUser);
  }
}
