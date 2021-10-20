package com.nerdearla.workshop.user.seller

import com.nerdearla.workshop.shared.utils.CompanionLogger
import com.nerdearla.workshop.user.seller.client.SellerClient
import com.nerdearla.workshop.user.seller.validator.SellerValidator
import org.springframework.stereotype.Service

@Service
class SellerService(
    private val client: SellerClient,
    private val validator: SellerValidator
) {
    fun getBy(id: String) =
        doGet(id)
            .also { it.validate() }

    private fun doGet(id: String) =
        client.getBy(id)
            .log { info("seller found {}", it) }

    private fun Seller.validate() {
        validator.validate(this)
            .log { info("seller {} validated", id) }
    }

    companion object : CompanionLogger()
}


