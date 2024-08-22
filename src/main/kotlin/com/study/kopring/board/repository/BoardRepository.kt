package com.study.kopring.board.repository

import com.study.kopring.board.entity.Board
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository : JpaRepository<Board, Long> {
    fun findByUseYnOrderByIdDesc(pageable: Pageable, useYn: String): Page<Board>
}