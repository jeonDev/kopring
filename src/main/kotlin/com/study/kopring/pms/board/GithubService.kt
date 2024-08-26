package com.study.kopring.pms.board

interface GithubService {
    fun <O> getApiCall(uri:String, resClass:Class<O>): O
}