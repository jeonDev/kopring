package com.study.kopring.pms.board

import com.study.kopring.pms.board.vo.response.GithubCommitHistory

interface GithubService {
    fun getApiCall(uri:String): List<GithubCommitHistory>?
}