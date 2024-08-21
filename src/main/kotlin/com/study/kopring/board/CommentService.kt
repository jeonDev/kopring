package com.study.kopring.board

import com.study.kopring.board.vo.request.PComment
import com.study.kopring.board.vo.response.RComment

interface CommentService {

    fun get(boardSeq: Long): List<RComment>
    fun add(pComment: PComment): RComment
}