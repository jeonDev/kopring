package com.study.kopring.config

import com.study.kopring.config.filter.LoggingFilter
import jakarta.servlet.Filter
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun loggingFilter() : FilterRegistrationBean<Filter> {
        return FilterRegistrationBean(LoggingFilter())
    }
}