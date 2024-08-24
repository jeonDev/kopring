package com.study.kopring.endpoint

import com.study.kopring.board.CommentService
import com.study.kopring.board.vo.request.PComment
import com.study.kopring.board.vo.response.RComment
import org.springframework.http.ResponseEntity
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
    fun get(@RequestParam("boardSeq") boardSeq:Long): ResponseEntity<List<RComment>> {
        val result = commentService.get(boardSeq)
        return ResponseEntity.ok().body(result)
    }

    @PostMapping("/v1/comment")
    fun add(@RequestBody pComment: PComment) : ResponseEntity<RComment> {
        val result = commentService.add(pComment)
        return ResponseEntity.ok().body(result)
    }
}