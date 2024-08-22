package com.study.kopring.config.exception

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {
    private val log = LoggerFactory.getLogger(ExceptionHandler::class.java)

    @ExceptionHandler(Exception::class)
    protected fun handleException(e: Exception) : ResponseEntity<ErrorResponse> {
        log.error("Exception Log : {}", e.message, e)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ErrorResponse())
    }


}