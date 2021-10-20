package com.nerdearla.workshop.user.seller.validator;

import com.nerdearla.workshop.user.seller.Seller;
import com.nerdearla.workshop.user.seller.error.DisabledSellerError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SellerValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(SellerValidator.class);

    public void validate(Seller seller) {
        validateIsEnabled(seller);
    }

    private void validateIsEnabled(Seller seller) {
        if (Boolean.FALSE.equals(seller.getEnabled())) {
            LOGGER.error("seller {} is disabled", seller.getId());
            throw new DisabledSellerError();
        }
        LOGGER.info("seller {} is enabled", seller.getId());
    }
}
