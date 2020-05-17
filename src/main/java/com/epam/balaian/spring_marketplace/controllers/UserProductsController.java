package com.epam.balaian.spring_marketplace.controllers;

import com.epam.balaian.spring_marketplace.model.Product;
import com.epam.balaian.spring_marketplace.model.User;
import com.epam.balaian.spring_marketplace.service.ProductService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vardan Balaian
 * @created 19.02.2020
 * @since 1.8
 */
@Controller
public class UserProductsController {

  private final ProductService productService;

  @Autowired
  public UserProductsController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/user_products")
  public String getUserProductsInfo(@AuthenticationPrincipal User user, Model model) {
    Iterable<Product> userProducts = productService.findAllByProductOwnerId(user.getId());

    long userProductNumber = userProducts.spliterator().getExactSizeIfKnown();

    model.addAttribute("userProducts", userProducts);
    model.addAttribute("userProductNumber", userProductNumber);

    return "user_products";
  }

  @PostMapping("/add")
  public String productAddingRedirect() {
    return "redirect:/user_products/adding";
  }

  @PostMapping("/edit")
  public String productEditingRedirect(
      @RequestParam Integer userProductIdForEditing, HttpServletRequest request) {
    Product selectedProduct = productService.getById(userProductIdForEditing);

    request.getSession().setAttribute("selectedProduct", selectedProduct);

    return "redirect:/user_products/editing";
  }

  @PostMapping("/delete")
  public String productDelete(@RequestParam Integer userProductIdForDelete) {

    productService.deleteProduct(userProductIdForDelete);

    return "redirect:/user_products";
  }
}
