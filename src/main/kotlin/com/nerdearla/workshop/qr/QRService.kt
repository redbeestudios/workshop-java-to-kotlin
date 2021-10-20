package com.nerdearla.workshop.qr

import com.nerdearla.workshop.qr.client.QrClient
import com.nerdearla.workshop.qr.validator.QrValidator
import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.stereotype.Service

@Service
class QRService(
    private val client: QrClient,
    private val validator: QrValidator
) {
    fun getBy(id: String) =
        doGet(id)
            .also { it.validate() }

    private fun doGet(id: String) =
        client.getBy(id)
            .log { info("qr found: {}", it) }

    private fun QR.validate() =
        validator.validate(this)
            .log { info("qr {} validated", id) }

    companion object : CompanionLogger()
}
