package com.study.kopring.config.exception

import org.slf4j.LoggerFactory
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {
    private val log = LoggerFactory.getLogger(ExceptionHandler::class.java)

    @ExceptionHandler(ServiceException::class)
    protected fun serviceHandleException(e:ServiceException): ResponseEntity<ErrorResponse> {
        log.error("serviceHandleException Log : {}", e.message, e)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ErrorResponse(
                errorCode = e.errorCode,
                errorMessage = e.errorMessage
            ))
    }

    @ExceptionHandler(DataIntegrityViolationException::class)
    protected fun dataIntegrityViolationHandleException(e: DataIntegrityViolationException) : ResponseEntity<ErrorResponse> {
        log.error("dataIntegrityViolationHandleException Log : {}", e.message, e)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ErrorResponse(
                errorMessage = "Data Error."
            ))
    }

    @ExceptionHandler(Exception::class)
    protected fun handleException(e: Exception) : ResponseEntity<ErrorResponse> {
        log.error("Exception Log : {}", e.message, e)
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ErrorResponse())
    }

}