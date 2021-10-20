package com.nerdearla.workshop.user.buyer.validator;

import com.nerdearla.workshop.user.buyer.Buyer;
import com.nerdearla.workshop.user.buyer.error.AddressNonExistentError;
import com.nerdearla.workshop.user.buyer.error.DisabledBuyerError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BuyerValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(BuyerValidator.class);

    public void validate(Buyer buyer) {
        validateIsEnabled(buyer);
        validateExistingAddress(buyer);
    }

    private void validateIsEnabled(Buyer buyer) {
        if (Boolean.FALSE.equals(buyer.getEnabled())) {
            LOGGER.error("buyer {} is disabled", buyer.getId());
            throw new DisabledBuyerError();
        }
        LOGGER.info("buyer {} is enabled", buyer.getId());
    }

    private void validateExistingAddress(Buyer buyer) {
        if (buyer.getAddress() == null) {
            LOGGER.error("buyer {} does not have address", buyer.getId());
            throw new AddressNonExistentError();
        }
        LOGGER.info("buyer {} has address", buyer.getId());
    }

}
