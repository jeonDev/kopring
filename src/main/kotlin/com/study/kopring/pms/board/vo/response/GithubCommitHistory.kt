package com.study.kopring.pms.board.vo.response

import com.fasterxml.jackson.annotation.JsonProperty

class GithubCommitHistory (
    val sha: String?,
    @JsonProperty("node_id")
    val nodeId: String?,
    val commit: Commit?,
    val url: String?,
    @JsonProperty("html_url")
    val htmlUrl: String?,
    @JsonProperty("comments_url")
    val commentsUrl: String?
){

    class Commit(
        val author: Author?,
        val committer: Committer?,
        val message: String?,
        val url: String?,
        @JsonProperty("comment_count")
        val commentCount: Int?
    ) {
        class Author (
            val name: String?,
            val email: String?,
            val date: String?
        )

        class Committer (
            val name: String?,
            val email: String?,
            val date: String?
        )
    }

}