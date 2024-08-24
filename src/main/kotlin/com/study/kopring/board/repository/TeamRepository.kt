package com.study.kopring.board.repository

import com.study.kopring.board.entity.Team
import org.springframework.data.jpa.repository.JpaRepository

interface TeamRepository: JpaRepository<Team, Long> {
}