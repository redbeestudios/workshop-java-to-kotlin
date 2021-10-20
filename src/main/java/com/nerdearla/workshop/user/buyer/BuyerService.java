package com.nerdearla.workshop.user.buyer;

import com.nerdearla.workshop.user.buyer.client.BuyerClient;
import com.nerdearla.workshop.user.buyer.validator.BuyerValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BuyerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuyerService.class);

    private final BuyerClient client;
    private final BuyerValidator validator;

    public BuyerService(BuyerClient client, BuyerValidator validator) {
        this.client = client;
        this.validator = validator;
    }

    public Buyer findBuyer(String buyerId) {
        Buyer buyer = client.getById(buyerId);
        LOGGER.info("buyer found {}", buyer.toString());
        validator.validate(buyer);
        LOGGER.info("buyer {} validated", buyer.getId());
        return buyer;
    }
}
