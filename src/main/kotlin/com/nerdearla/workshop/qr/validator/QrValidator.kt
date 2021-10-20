package com.nerdearla.workshop.qr.validator

import com.nerdearla.workshop.qr.QR
import com.nerdearla.workshop.qr.error.DisabledQrError
import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.stereotype.Component

@Component
class QrValidator {

    fun validate(qr: QR) {
        validateIsEnabled(qr)
    }

    private fun validateIsEnabled(qr: QR) {
        if (qr.enabled.not()) {
            log.error("qr {} is disabled", qr.id)
            throw DisabledQrError()
        }
        log.info("qr {} is enabled", qr.id)
    }

    companion object : CompanionLogger()
}
