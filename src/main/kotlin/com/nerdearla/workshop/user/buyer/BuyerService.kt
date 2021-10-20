package com.nerdearla.workshop.user.buyer

import com.nerdearla.workshop.shared.utils.CompanionLogger
import com.nerdearla.workshop.user.buyer.client.BuyerClient
import com.nerdearla.workshop.user.buyer.validator.BuyerValidator
import org.springframework.stereotype.Service

@Service
class BuyerService(
    private val client: BuyerClient,
    private val validator: BuyerValidator
) {
    fun getBy(id: String): Buyer =
        doGet(id)
            .also { it.validate() }

    private fun doGet(id: String) =
        client.getBy(id)
            .log { info("buyer found {}", it) }

    private fun Buyer.validate() =
        validator.validate(this)
            .log { info("buyer {} validated", id) }

    companion object : CompanionLogger()
}
