package com.epam.balaian.spring_marketplace.controllers;

import com.epam.balaian.spring_marketplace.model.Role;
import com.epam.balaian.spring_marketplace.model.User;
import com.epam.balaian.spring_marketplace.service.RoleService;
import com.epam.balaian.spring_marketplace.service.UserService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Vardan Balaian
 * @created 2/17/2020
 * @since 1.8
 */
@Controller
@RequestMapping(path = "/registration")
public class RegistrationController {

  private final UserService userService;
  private final RoleService roleService;

  @Autowired
  public RegistrationController(UserService userService, RoleService roleService) {
    this.userService = userService;
    this.roleService = roleService;
  }

  @GetMapping
  public String getRegistration() {
    return "registration";
  }

  @PostMapping
  public String addUser(User user, Model model) {

    User userFromDB = userService.findByLoginName(user.getLoginName());

    if (Objects.nonNull(userFromDB)) {
      model.addAttribute("userExistsMessage", "Entered login is reserved by registered user!");
      return "registration";
    }

    Role role = roleService.findByTitle("User");
    user.setRole(role);
    userService.saveUser(user);

    return "redirect:/product_table";
  }
}
