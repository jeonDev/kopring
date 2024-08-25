package com.study.kopring.pms.board

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class GithubServiceImpl(
    private val githubWebClient: WebClient
):GithubService {
    private val log = LoggerFactory.getLogger(this::class.java)

    // //curl -H "Accept: application/vnd.github+json"   https://api.github.com/repos/jeonDev/kopring/commits/main/status
    override fun getApiCall(uri:String) {
        val response = githubWebClient.get()
            .uri(uri)
            .headers { h ->
                h.add("Accept", "application/vnd.github+json")
            }
            .retrieve()
            .toEntity(String::class.java)
            .block()
        log.info(response.toString())
    }
}