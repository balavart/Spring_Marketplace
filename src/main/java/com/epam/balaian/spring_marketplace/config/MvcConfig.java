package com.epam.balaian.spring_marketplace.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Vardan Balaian
 * @created 14.02.2020
 * @since 1.8
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/login").setViewName("login");
  }
}
