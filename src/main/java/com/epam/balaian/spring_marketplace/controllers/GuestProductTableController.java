package com.epam.balaian.spring_marketplace.controllers;

import com.epam.balaian.spring_marketplace.model.Product;
import com.epam.balaian.spring_marketplace.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Vardan Balaian
 * @created 2/18/2020
 * @since 1.8
 */
@Controller
@RequestMapping(path = "/guest_product_table")
public class GuestProductTableController {

  private final ProductService productService;

  @Autowired
  public GuestProductTableController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public String getProductsInfo(
      @RequestParam(required = false, defaultValue = "") String filter, Model model) {
    Iterable<Product> products;

    if (filter != null && !filter.isEmpty()) {
      products = productService.findAllByTitleIgnoreCaseContaining(filter);
    } else {
      products = productService.findAll();
    }

    long productNumber = products.spliterator().getExactSizeIfKnown();

    model.addAttribute("products", products);
    model.addAttribute("filter", filter);
    model.addAttribute("productNumber", productNumber);

    return "guest_product_table";
  }
}
