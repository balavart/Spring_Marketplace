package com.epam.balaian.spring_marketplace.repositories;

import com.epam.balaian.spring_marketplace.model.Bidding;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Vardan Balaian
 * @created 2/19/2020
 * @since 1.8
 */
@Repository
@Transactional
public interface BiddingRepository extends CrudRepository<Bidding, Integer> {

  Bidding getById(Integer id);
}
