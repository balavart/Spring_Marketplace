package com.epam.balaian.spring_marketplace.service;

import com.epam.balaian.spring_marketplace.model.StatusType;
import com.epam.balaian.spring_marketplace.repositories.StatusTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Vardan Balaian
 * @created 2/21/2020
 * @since 1.8
 */
@Service
public class StatusTypeServiceImpl implements StatusTypeService {

  private final StatusTypeRepository statusRepository;

  @Autowired
  public StatusTypeServiceImpl(StatusTypeRepository statusRepository) {
    this.statusRepository = statusRepository;
  }

  @Override
  public StatusType findByTitle(String statusTitle) {
    return statusRepository.findByTitle(statusTitle);
  }
}
