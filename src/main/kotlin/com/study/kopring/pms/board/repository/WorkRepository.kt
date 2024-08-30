package com.study.kopring.pms.board.repository

import com.study.kopring.pms.board.entity.Work
import org.springframework.data.jpa.repository.JpaRepository

interface WorkRepository: JpaRepository<Work, Long> {
}