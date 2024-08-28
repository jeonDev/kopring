package com.study.kopring.pms.board

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.type.TypeFactory
import com.study.kopring.pms.board.vo.response.GithubCommitHistory
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient

@Service
class GithubServiceImpl(
    private val githubWebClient: WebClient,
    private val objectMapper: ObjectMapper
):GithubService {
    private val log = LoggerFactory.getLogger(this::class.java)

    override fun getApiCall(uri: String): List<GithubCommitHistory>? {
        val response: String? = githubWebClient.get()
            .uri(uri)
            .headers { h ->
                h.add("Accept", "application/vnd.github+json")
            }
            .retrieve()
            .bodyToMono(String::class.java)
            .block()
        log.info(response)

        val type = TypeFactory.defaultInstance().constructCollectionType(List::class.java, GithubCommitHistory::class.java)
        return objectMapper.readValue(response, type)
    }
}