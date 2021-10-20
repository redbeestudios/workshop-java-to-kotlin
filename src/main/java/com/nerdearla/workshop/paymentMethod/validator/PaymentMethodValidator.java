package com.nerdearla.workshop.paymentMethod.validator;

import com.nerdearla.workshop.payment.service.model.PaymentMethodData;
import com.nerdearla.workshop.paymentMethod.BuyerPaymentMethod;
import com.nerdearla.workshop.paymentMethod.error.DisabledPaymentMethodError;
import com.nerdearla.workshop.paymentMethod.error.InvalidSecurityCodeError;
import com.nerdearla.workshop.paymentMethod.error.InvalidTokenError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PaymentMethodValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaymentMethodValidator.class);

    public void validate(BuyerPaymentMethod buyerPaymentMethod, PaymentMethodData paymentMethodData) {
        validateIsEnabled(buyerPaymentMethod);
        validateSecurityCode(buyerPaymentMethod.getSecurityCode(), paymentMethodData.getSecurityCode());
        validateToken(buyerPaymentMethod.getToken(), paymentMethodData.getToken());
    }

    private void validateIsEnabled(BuyerPaymentMethod buyerPaymentMethod) {
        if (Boolean.FALSE.equals(buyerPaymentMethod.getEnabled())) {
            LOGGER.error("Payment method {} is not enabled", buyerPaymentMethod.getId());
            throw new DisabledPaymentMethodError();
        }
        LOGGER.info("Payment method {} is enabled", buyerPaymentMethod.getId());
    }

    private void validateSecurityCode(String expected, String actual) {
        if (!expected.equals(actual)) {
            LOGGER.error("securityCode {} doesnt match expectation", actual);
            throw new InvalidSecurityCodeError();
        }
        LOGGER.info("securityCode validated successfully");
    }

    private void validateToken(String expected, String actual) {
        if (!expected.equals(actual)) {
            LOGGER.error("token {} doesnt match expectation", actual);
            throw new InvalidTokenError();
        }
        LOGGER.info("token validated successfully");
    }
}
