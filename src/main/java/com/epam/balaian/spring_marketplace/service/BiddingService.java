package com.epam.balaian.spring_marketplace.service;

import com.epam.balaian.spring_marketplace.model.Bidding;
import com.epam.balaian.spring_marketplace.model.StatusType;
import com.epam.balaian.spring_marketplace.model.User;
import java.sql.Date;

/**
 * @author Vardan Balaian
 * @created 2/21/2020
 * @since 1.8
 */
public interface BiddingService {

  Bidding getById(Integer id);

  void saveBidding(Bidding bidding);

  void editBidding(
      Bidding modifiedBidding, Double newStartingPrice, Date newEndDate, StatusType newStatus);

  void editBiddingWithOffer(Integer biddingId, User userAsSupposedBidder, Double offer);
}
