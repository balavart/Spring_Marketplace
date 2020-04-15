package com.epam.balaian.spring_marketplace.controllers;

import com.epam.balaian.spring_marketplace.model.Bidding;
import com.epam.balaian.spring_marketplace.model.Product;
import com.epam.balaian.spring_marketplace.model.StatusType;
import com.epam.balaian.spring_marketplace.model.User;
import com.epam.balaian.spring_marketplace.service.BiddingService;
import com.epam.balaian.spring_marketplace.service.ProductService;
import com.epam.balaian.spring_marketplace.service.StatusTypeService;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
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
 * @created 20.02.2020
 * @since 1.8
 */
@Controller
@RequestMapping(path = "/user_products/editing")
public class ProductEditingController {

  private final StatusTypeService statusService;
  private final BiddingService biddingService;
  private final ProductService productService;

  @Autowired
  public ProductEditingController(
      StatusTypeService statusService,
      BiddingService biddingService,
      ProductService productService) {
    this.statusService = statusService;
    this.biddingService = biddingService;
    this.productService = productService;
  }

  @GetMapping
  public String getProductEditingView(HttpServletRequest request, Model model) {
    Product selectedUserProduct = (Product) request.getSession().getAttribute("selectedProduct");

    model.addAttribute("userProduct", selectedUserProduct);

    return "product_editing";
  }

  @PostMapping
  public String editProduct(
      HttpServletRequest request,
      @RequestParam String title,
      @RequestParam String description,
      @RequestParam Double startingPrice,
      @RequestParam Date endDate,
      @RequestParam String status,
      @AuthenticationPrincipal User loggedUser) {

    Product modifiedProduct = (Product) request.getSession().getAttribute("selectedProduct");
    Bidding modifiedBidding = modifiedProduct.getProductBidding();

    StatusType newStatus = statusService.findByTitle(status);
    biddingService.editBidding(modifiedBidding, startingPrice, endDate, newStatus);
    productService.editProduct(modifiedProduct, title, description, modifiedBidding, loggedUser);

    request.getSession().removeAttribute("selectedProduct");

    return "redirect:/user_products";
  }
}
