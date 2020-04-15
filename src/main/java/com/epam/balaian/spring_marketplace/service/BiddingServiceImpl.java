package com.epam.balaian.spring_marketplace.service;

import com.epam.balaian.spring_marketplace.model.Bidding;
import com.epam.balaian.spring_marketplace.model.StatusType;
import com.epam.balaian.spring_marketplace.model.User;
import com.epam.balaian.spring_marketplace.repositories.BiddingRepository;
import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Vardan Balaian
 * @created 2/21/2020
 * @since 1.8
 */
@Service
public class BiddingServiceImpl implements BiddingService {

  private final BiddingRepository biddingRepository;

  @Autowired
  public BiddingServiceImpl(BiddingRepository biddingRepository) {
    this.biddingRepository = biddingRepository;
  }

  @Override
  public Bidding getById(Integer id) {
    return biddingRepository.getById(id);
  }

  @Override
  public void saveBidding(Bidding newBidding) {
    biddingRepository.save(newBidding);
  }

  @Override
  public void editBiddingWithOffer(Integer biddingId, User userAsSupposedBidder, Double offer) {
    Bidding modifiedBidding = getById(biddingId);
    modifiedBidding.setSupposedBidder(userAsSupposedBidder);
    modifiedBidding.setBestOffer(offer);
    biddingRepository.save(modifiedBidding);
  }

  @Override
  public void editBidding(
      Bidding modifiedBidding, Double newStartingPrice, Date newEndDate, StatusType newStatus) {
    modifiedBidding.setStartingPrice(newStartingPrice);
    modifiedBidding.setOfferEndDate(newEndDate);
    modifiedBidding.setStatus(newStatus);
    biddingRepository.save(modifiedBidding);
  }
}
