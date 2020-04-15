package com.epam.balaian.spring_marketplace.repositories;

import com.epam.balaian.spring_marketplace.model.StatusType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Vardan Balaian
 * @created 2/20/2020
 * @since 1.8
 */
@Repository
@Transactional
public interface StatusTypeRepository extends CrudRepository<StatusType, Integer> {

  StatusType findByTitle(String title);
}
