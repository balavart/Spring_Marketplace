package com.epam.balaian.spring_marketplace.service;

import com.epam.balaian.spring_marketplace.model.Bidding;
import com.epam.balaian.spring_marketplace.model.Product;
import com.epam.balaian.spring_marketplace.model.User;
import java.util.List;

/**
 * @author Vardan Balaian
 * @created 2/21/2020
 * @since 1.8
 */
public interface ProductService {

  Product getById(Integer id);

  Iterable<Product> findAll();

  List<Product> findAllByTitleIgnoreCaseContaining(String title);

  List<Product> findAllByProductOwnerId(Integer productOwnerId);

  void deleteProduct(Integer id);

  void saveProduct(Product persistentProduct, User userAsProductOwner, Bidding newBidding);

  void editProduct(
      Product modifiedProduct,
      String newTitle,
      String newDescription,
      Bidding newBidding,
      User userAsProductOwner);
}
