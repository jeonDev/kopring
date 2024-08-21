package com.study.kopring.config.exception

import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Getter
import java.time.LocalDateTime

@Getter
@Builder
@AllArgsConstructor
class ErrorResponse (
    val errorCode: String? = "99",
    val errorMessage: String = "System Error",
    val timestamp: String = LocalDateTime.now().toString()
){
}