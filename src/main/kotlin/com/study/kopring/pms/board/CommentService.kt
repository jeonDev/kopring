package com.study.kopring.pms.board

import com.study.kopring.pms.board.vo.request.PComment
import com.study.kopring.pms.board.vo.response.RComment

interface CommentService {

    fun get(boardSeq: Long): List<RComment>
    fun add(pComment: PComment): RComment
}