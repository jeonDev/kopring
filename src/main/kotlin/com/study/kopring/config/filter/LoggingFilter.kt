package com.study.kopring.config.filter

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Slf4j
class LoggingFilter : Filter{
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val req:HttpServletRequest = request as HttpServletRequest
        logger.info("url : {}" ,req.requestURL.toString())
        chain?.doFilter(request, response)
    }
}