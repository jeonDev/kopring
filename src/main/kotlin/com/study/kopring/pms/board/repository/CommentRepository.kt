package com.study.kopring.pms.board.repository

import com.study.kopring.pms.board.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository:JpaRepository<Comment, Long> {
    fun findByBoardId(boardSeq: Long): List<Comment>
}