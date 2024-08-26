package com.study.kopring.pms.board.vo.response

import com.study.kopring.pms.board.vo.type.BoardType

class RBoard (
    val boardSeq: Long? = null,
    val title: String? = null,
    val content: String? = null,
    val useYn: String? = null,
    val boardType: BoardType? = null,
    val githubCommitHistory: GithubCommitHistory? = null
) {

}