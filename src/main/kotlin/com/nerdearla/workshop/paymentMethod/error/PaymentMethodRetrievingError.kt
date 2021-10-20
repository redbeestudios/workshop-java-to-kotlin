package com.nerdearla.workshop.paymentMethod.error

import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.web.server.ResponseStatusException

class PaymentMethodRetrievingError :
    ResponseStatusException(INTERNAL_SERVER_ERROR, "error while retrieving payment method")
