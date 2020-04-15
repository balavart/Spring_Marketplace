package com.epam.balaian.spring_marketplace.controllers;

import com.epam.balaian.spring_marketplace.model.Product;
import com.epam.balaian.spring_marketplace.model.User;
import com.epam.balaian.spring_marketplace.service.BiddingService;
import com.epam.balaian.spring_marketplace.service.ProductService;
import java.util.Objects;
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
 * @created 13.02.2020
 * @since 1.8
 */
@Controller
@RequestMapping(path = "/product_table")
public class ProductTableController {

  private final ProductService productService;
  private final BiddingService biddingService;

  @Autowired
  public ProductTableController(ProductService productService, BiddingService biddingService) {
    this.productService = productService;
    this.biddingService = biddingService;
  }

  @GetMapping
  public String getProductsInfo(
      @RequestParam(required = false, defaultValue = "") String filter,
      HttpServletRequest request,
      Model model) {

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

    if (Objects.nonNull(request.getSession().getAttribute("priceErrorMessage"))) {
      model.addAttribute(
          "priceErrorMessage",
          "The indicated price offer cannot be less than or equal to the existing offer and start price.");
      request.getSession().removeAttribute("priceErrorMessage");
    } else if (Objects.nonNull(request.getSession().getAttribute("ownerOfferErrorMessage"))) {
      model.addAttribute("ownerOfferErrorMessage", "You cannot bid in your own auction.");

      request.getSession().removeAttribute("ownerOfferErrorMessage");
    }

    return "product_table";
  }

  @PostMapping
  public String getCorrectBestOffer(
      @AuthenticationPrincipal User loggedUser,
      @RequestParam Double offer,
      @RequestParam Integer productIdOfThisOffer,
      HttpServletRequest request) {

    Product existingProduct = productService.getById(productIdOfThisOffer);
    Double existingStartingprice = existingProduct.getProductBidding().getStartingPrice();
    Double existingOffer = existingProduct.getProductBidding().getBestOffer();

    Integer supposedBidderId = loggedUser.getId();
    Integer productOwnerId = existingProduct.getProductOwner().getId();

    if (Objects.nonNull(existingOffer)
        && (offer <= existingOffer || offer <= existingStartingprice)) {
      request.getSession().setAttribute("priceErrorMessage", true);

      return "redirect:/product_table";
    } else if (supposedBidderId.equals(productOwnerId)) {
      request.getSession().setAttribute("ownerOfferErrorMessage", true);

      return "redirect:/product_table";
    }

    Integer existingBiddingId = existingProduct.getProductBidding().getId();
    biddingService.editBiddingWithOffer(existingBiddingId, loggedUser, offer);

    return "redirect:/product_table";
  }
}
