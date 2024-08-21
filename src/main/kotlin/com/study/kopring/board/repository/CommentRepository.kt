package com.study.kopring.board.repository

import com.study.kopring.board.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository:JpaRepository<Comment, Long> {
    fun findByBoardId(boardSeq: Long): List<Comment>
}