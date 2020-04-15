package com.epam.balaian.spring_marketplace.service;

import com.epam.balaian.spring_marketplace.model.Bidding;
import com.epam.balaian.spring_marketplace.model.Product;
import com.epam.balaian.spring_marketplace.model.User;
import com.epam.balaian.spring_marketplace.repositories.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Vardan Balaian
 * @created 2/21/2020
 * @since 1.8
 */
@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Autowired
  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @Override
  public Product getById(Integer id) {
    return productRepository.getById(id);
  }

  @Override
  public Iterable<Product> findAll() {
    return productRepository.findAll();
  }

  @Override
  public List<Product> findAllByTitleIgnoreCaseContaining(String title) {
    return productRepository.findAllByTitleIgnoreCaseContaining(title);
  }

  @Override
  public List<Product> findAllByProductOwnerId(Integer productOwnerId) {
    return productRepository.findAllByProductOwner_Id(productOwnerId);
  }

  @Override
  public void deleteProduct(Integer id) {
    productRepository.deleteById(id);
  }

  @Override
  public void saveProduct(Product persistentProduct, User userAsProductOwner, Bidding newBidding) {
    persistentProduct.setProductOwner(userAsProductOwner);
    persistentProduct.setProductBidding(newBidding);
    productRepository.save(persistentProduct);
  }

  @Override
  public void editProduct(
      Product modifiedProduct,
      String newTitle,
      String newDescription,
      Bidding newBidding,
      User userAsProductOwner) {
    modifiedProduct.setTitle(newTitle);
    modifiedProduct.setDescription(newDescription);
    modifiedProduct.setProductBidding(newBidding);
    modifiedProduct.setProductOwner(userAsProductOwner);
    productRepository.save(modifiedProduct);
  }
}
