package com.study.kopring.config.exception

class ServiceException(
    var errorCode:String = "99",
    var errorMessage:String = "System Error"
): RuntimeException() {

    constructor(serviceError: ServiceError) : this() {
        errorCode = serviceError.getErrorCode()
        errorMessage = serviceError.getErrorMessage()
    }
}