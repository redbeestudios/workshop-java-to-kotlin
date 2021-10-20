package com.nerdearla.workshop.shared.advice;

import com.nerdearla.workshop.shared.error.APIError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public APIError handleException(Exception e) {
        return new APIError(e.getMessage());
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<APIError> handleResponseStatusException(ResponseStatusException e) {
        return new ResponseEntity<>(
                new APIError(e.getReason()),
                e.getStatus()
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIError> handleValidationException(MethodArgumentNotValidException e) {
        final FieldError fieldError = Objects.requireNonNull(e.getBindingResult().getFieldError());
        return ResponseEntity.badRequest().body(
                new APIError(snakeCasedField(fieldError) + ": " + fieldError.getDefaultMessage()));
    }

    private String snakeCasedField(FieldError fieldError) {
        return fieldError.getField()
                .replaceAll("([a-z])([A-Z]+)", "$1_$2")
                .toLowerCase();
    }
}
