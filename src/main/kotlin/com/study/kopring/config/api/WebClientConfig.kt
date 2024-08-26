package com.study.kopring.config.api

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.ClientRequest
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.ExchangeFilterFunction
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Configuration
class WebClientConfig {
    private val log = LoggerFactory.getLogger(this::class.java)

    @Bean
    fun githubWebClient(@Value("\${api.github-url}") githubUrl:String ):WebClient {
        return WebClient.builder()
            .baseUrl(githubUrl)
            .filters{it ->
                it.add(requestFilter())
            }
            .build()
    }

    private fun requestFilter() :ExchangeFilterFunction {
        return ExchangeFilterFunction.ofRequestProcessor {request: ClientRequest ->
            log.info("Request ${request.method()} ${request.url()} ${request.headers()}")
            Mono.just(request)
        }
    }

    private fun responseFilter() :ExchangeFilterFunction {
        return ExchangeFilterFunction.ofResponseProcessor() {response: ClientResponse ->
            log.info("Response ${response.statusCode()}")
            Mono.just(response)
        }
    }
}