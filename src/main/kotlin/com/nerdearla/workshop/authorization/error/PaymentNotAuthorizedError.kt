package com.nerdearla.workshop.authorization.error

import org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY
import org.springframework.web.server.ResponseStatusException

class PaymentNotAuthorizedError:
    ResponseStatusException(UNPROCESSABLE_ENTITY, "payment not authorized")
