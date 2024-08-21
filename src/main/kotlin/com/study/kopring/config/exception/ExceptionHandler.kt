package com.study.kopring.config.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(Exception::class)
    protected fun handleException(e: Exception) : ResponseEntity<ErrorResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ErrorResponse())
    }


}