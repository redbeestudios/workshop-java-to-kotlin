package com.nerdearla.workshop.user.buyer.validator

import com.nerdearla.workshop.shared.utils.CompanionLogger
import com.nerdearla.workshop.user.buyer.Buyer
import com.nerdearla.workshop.user.buyer.error.AddressNonExistentError
import com.nerdearla.workshop.user.buyer.error.DisabledBuyerError
import org.springframework.stereotype.Component

@Component
class BuyerValidator {

    fun validate(buyer: Buyer) =
        with(buyer) {
            validateIsEnabled()
            validateExistingAddress()
        }

    private fun Buyer.validateIsEnabled() {
        if (enabled.not()) {
            log.error("buyer {} is disabled", id)
            throw DisabledBuyerError()
        }
        log.info("buyer {} is enabled", id)
    }

    private fun Buyer.validateExistingAddress() {
        if (address == null) {
            log.error("buyer {} does not have address", id)
            throw AddressNonExistentError()
        }
        log.info("buyer {} has address", id)
    }


    companion object : CompanionLogger()
}
