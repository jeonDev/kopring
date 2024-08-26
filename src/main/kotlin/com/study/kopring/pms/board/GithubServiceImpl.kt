package com.study.kopring.pms.board

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class GithubServiceImpl(
    private val githubWebClient: WebClient
):GithubService {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun <O> getApiCall(uri: String, resClass:Class<O>): O{
        val response: O? = githubWebClient.get()
            .uri(uri)
            .headers { h ->
                h.add("Accept", "application/vnd.github+json")
            }
            .retrieve()
            .bodyToMono(resClass)
            .block()
        return response!!
    }
}