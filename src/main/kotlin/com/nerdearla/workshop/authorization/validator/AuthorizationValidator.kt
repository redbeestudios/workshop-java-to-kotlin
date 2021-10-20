package com.nerdearla.workshop.authorization.validator

import com.nerdearla.workshop.authorization.PaymentAuthorization
import com.nerdearla.workshop.authorization.error.PaymentNotAuthorizedError
import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.stereotype.Component

@Component
class AuthorizationValidator {

    fun validate(paymentAuthorization: PaymentAuthorization) {
        paymentAuthorization.validateStatus()
    }

    private fun PaymentAuthorization.validateStatus() {
        if (status != "ACCEPTED") {
            log.error("payment not authorized")
            throw PaymentNotAuthorizedError()
        }

        log.info("payment status is ACCEPTED")
    }

    companion object : CompanionLogger()
}
