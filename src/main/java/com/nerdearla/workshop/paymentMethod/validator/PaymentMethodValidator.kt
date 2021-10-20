package com.nerdearla.workshop.paymentMethod.validator

import com.nerdearla.workshop.payment.service.model.PaymentMethodData
import com.nerdearla.workshop.paymentMethod.BuyerPaymentMethod
import com.nerdearla.workshop.paymentMethod.error.DisabledPaymentMethodError
import com.nerdearla.workshop.paymentMethod.error.InvalidSecurityCodeError
import com.nerdearla.workshop.paymentMethod.error.InvalidTokenError
import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.stereotype.Component

@Component
class PaymentMethodValidator {

    fun validate(buyerPaymentMethod: BuyerPaymentMethod, paymentMethodData: PaymentMethodData) {
        validateIsEnable(buyerPaymentMethod)
        validateSecurityCode(buyerPaymentMethod.securityCode, paymentMethodData.securityCode)
        validateToken(buyerPaymentMethod.token, paymentMethodData.token)
    }

    private fun validateIsEnable(buyerPaymentMethod: BuyerPaymentMethod) {
        if (buyerPaymentMethod.enabled.not()) {
            log.error("payment method {} is disabled", buyerPaymentMethod.id)
            throw DisabledPaymentMethodError()
        }

        log.info("payment method {} is enabled", buyerPaymentMethod.id)
    }

    private fun validateSecurityCode(expected: String, actual: String) {
        if (expected != actual) {
            log.error("securityCode {} doesnt match expectation", actual)
            throw InvalidSecurityCodeError()
        }

        log { info("securtyCode validated successfully") }
    }

    private fun validateToken(expected: String, actual: String) {
        if (expected != actual) {
            log.error("token {} doesnt match expectation", actual)
            throw InvalidTokenError()
        }

        log { info("token validated successfully") }
    }

    companion object : CompanionLogger()
}
