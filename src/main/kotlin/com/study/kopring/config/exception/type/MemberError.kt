package com.study.kopring.config.exception.type

import com.study.kopring.config.exception.ServiceError

enum class MemberError (
    private val errorCode: String,
    private val errorMessage: String
): ServiceError {
    NOT_EXISTS("100", "존재하지 않는 고객"),
    NOT_MATCH_PASSWORD("101", "패스워드 틀림");

    override fun getErrorCode(): String {
        return this.errorCode
    }

    override fun getErrorMessage(): String {
        return this.errorMessage
    }}
