package com.study.kopring.config.exception

interface ServiceError {

    fun getErrorCode(): String
    fun getErrorMessage(): String
}