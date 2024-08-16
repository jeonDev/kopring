package com.study.kopring.board

import com.study.kopring.board.vo.request.PComment
import com.study.kopring.board.vo.response.RComment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CommentController (
    val commentService: CommentService
){

    @GetMapping("/comment")
    fun get() : List<RComment> {
        return commentService.get()
    }

    @PostMapping("/comment")
    fun add(@RequestBody pComment: PComment) : RComment {
        return commentService.add(pComment)
    }
}