package com.epam.balaian.spring_marketplace.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Vardan Balaian
 * @created 2/12/2020
 * @since 1.8
 */
@Controller
@RequestMapping(path = "/")
public class GreetingController {

  @GetMapping
  public String greeting() {
    return "homepage";
  }
}
