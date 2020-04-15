package com.epam.balaian.spring_marketplace.controllers;

import com.epam.balaian.spring_marketplace.model.Bidding;
import com.epam.balaian.spring_marketplace.model.Product;
import com.epam.balaian.spring_marketplace.model.StatusType;
import com.epam.balaian.spring_marketplace.model.User;
import com.epam.balaian.spring_marketplace.service.BiddingService;
import com.epam.balaian.spring_marketplace.service.ProductService;
import com.epam.balaian.spring_marketplace.service.StatusTypeService;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Vardan Balaian
 * @created 2/20/2020
 * @since 1.8
 */
@Controller
@RequestMapping(path = "/user_products/adding")
public class ProductAddingController {

  private final StatusTypeService statusService;
  private final BiddingService biddingService;
  private final ProductService productService;

  @Autowired
  public ProductAddingController(
      StatusTypeService statusService,
      BiddingService biddingService,
      ProductService productService) {
    this.statusService = statusService;
    this.biddingService = biddingService;
    this.productService = productService;
  }

  @GetMapping
  public String getProductAddingView(@AuthenticationPrincipal User user, Model model) {
    Date currentDate = new Date(System.currentTimeMillis());

    model.addAttribute("loggedUserFullName", user.getFullName());
    model.addAttribute("currentDate", currentDate);

    return "product_adding";
  }

  @PostMapping
  public String addProduct(
      Product product,
      @AuthenticationPrincipal User loggedUser,
      @RequestParam Double startingPrice,
      @RequestParam Date endDate,
      @RequestParam String status) {

    StatusType newStatus = statusService.findByTitle(status);
    Bidding newBidding = new Bidding(startingPrice, endDate, 0D, newStatus);

    biddingService.saveBidding(newBidding);
    productService.saveProduct(product, loggedUser, newBidding);

    return "redirect:/user_products";
  }
}
