package com.study.kopring.endpoint.board

import com.study.kopring.board.CommentService
import com.study.kopring.board.vo.request.PComment
import com.study.kopring.board.vo.response.RComment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class CommentController (
    val commentService: CommentService
){

    @GetMapping("/v1/comment")
    fun get(@RequestParam("boardSeq") boardSeq:Long) : List<RComment> {
        return commentService.get(boardSeq)
    }

    @PostMapping("/v1/comment")
    fun add(@RequestBody pComment: PComment) : RComment {
        return commentService.add(pComment)
    }
}