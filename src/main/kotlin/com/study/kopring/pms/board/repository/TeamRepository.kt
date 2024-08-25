package com.study.kopring.pms.board.repository

import com.study.kopring.pms.board.entity.Team
import org.springframework.data.jpa.repository.JpaRepository

interface TeamRepository: JpaRepository<Team, Long> {
}