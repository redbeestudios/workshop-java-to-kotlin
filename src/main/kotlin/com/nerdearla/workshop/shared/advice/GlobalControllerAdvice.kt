package com.nerdearla.workshop.shared.advice

import com.nerdearla.workshop.shared.utils.CompanionLogger
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.server.ResponseStatusException
import javax.validation.ConstraintViolationException


@RestControllerAdvice
class GlobalControllerAdvice {

    @ExceptionHandler(HttpMessageNotReadableException::class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    fun onHttpMessageNotReadableException(e: Exception): ErrorResponse =
        ErrorResponse("request not readable")
            .log { info("message not readable identified: {}", e.message) }


    @ExceptionHandler(ConstraintViolationException::class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    fun onConstraintValidationException(e: ConstraintViolationException): ValidationErrorResponse =
        e.constraintViolations
            .map { Violation(it.propertyPath.toString(), it.message) }
            .let { ValidationErrorResponse(it) }
            .log { info("constraint violation identified: {}", e.message) }

    @ExceptionHandler(ResponseStatusException::class)
    fun onResponseStatusException(e: ResponseStatusException): ResponseEntity<ErrorResponse> =
        ResponseEntity<ErrorResponse>(
            ErrorResponse(e.reason!!),
            e.status
        ).log { info("error identified: {}", e.message) }


    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationException(e: MethodArgumentNotValidException): ResponseEntity<ErrorResponse> =
        e.bindingResult.fieldError
            .let {
                ResponseEntity.badRequest().body(ErrorResponse(it?.defaultMessage ?: "request not readable"))
            }

    companion object : CompanionLogger()

}

data class ErrorResponse(
    val message: String
)

data class ValidationErrorResponse(
    val violations: List<Violation>
)

data class Violation(
    val fieldName: String,
    val message: String
)
