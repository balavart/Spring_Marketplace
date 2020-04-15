package com.epam.balaian.spring_marketplace.repositories;

import com.epam.balaian.spring_marketplace.model.Product;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Vardan Balaian
 * @created 13.02.2020
 * @since 1.8
 */
@Repository
@Transactional
public interface ProductRepository extends CrudRepository<Product, Integer> {

  Product getById(Integer id);

  List<Product> findAllByTitleIgnoreCaseContaining(String title);

  List<Product> findAllByProductOwner_Id(Integer id);
}
