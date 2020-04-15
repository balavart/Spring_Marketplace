package com.epam.balaian.spring_marketplace.service;

import com.epam.balaian.spring_marketplace.model.User;
import com.epam.balaian.spring_marketplace.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Vardan Balaian
 * @created 17.02.2020
 * @since 1.8
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder passwordEncoder;

  @Autowired
  public UserDetailsServiceImpl(
      UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    User loggedUser = userRepository.findByLoginName(userName);
    loggedUser.setPassword(passwordEncoder.encode(loggedUser.getPassword()));
    return loggedUser;
  }
}
