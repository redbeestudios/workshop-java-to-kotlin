package com.nerdearla.workshop.user.seller.validator

import com.nerdearla.workshop.shared.utils.CompanionLogger
import com.nerdearla.workshop.user.seller.Seller
import com.nerdearla.workshop.user.seller.error.DisabledSellerError
import org.springframework.stereotype.Component

@Component
class SellerValidator {

    fun validate(seller: Seller) {
        seller.validateIsEnabled()
    }

    private fun Seller.validateIsEnabled() {
        if (enabled.not()) {
            log.error("seller {} is disabled", id)
            throw DisabledSellerError()
        }
        log.info("seller {} is enabled", id)
    }

    companion object : CompanionLogger()
}
