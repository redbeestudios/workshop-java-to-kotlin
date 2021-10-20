package com.nerdearla.workshop.authorization.validator;

import com.nerdearla.workshop.authorization.PaymentAuthorization;
import com.nerdearla.workshop.authorization.error.PaymentNotAuthorizedError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PaymentAuthorizationValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentAuthorizationValidator.class);

    private static final String ACCEPTED_STATUS = "ACCEPTED";

    public void validate(PaymentAuthorization paymentAuthorization) {
        if (!ACCEPTED_STATUS.equals(paymentAuthorization.getStatus())) {
            LOGGER.error("payment not authorized");
            throw new PaymentNotAuthorizedError();
        }

        LOGGER.info("payment status is ACCEPTED");
    }
}
