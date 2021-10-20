package com.nerdearla.workshop.paymentMethod.error

import org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import org.springframework.web.server.ResponseStatusException

class DisabledPaymentMethodError :
    ResponseStatusException(UNPROCESSABLE_ENTITY, "payment method disabled")
