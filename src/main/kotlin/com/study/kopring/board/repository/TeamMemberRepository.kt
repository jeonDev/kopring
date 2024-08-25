package com.study.kopring.board.repository

import com.study.kopring.board.entity.TeamMember
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface TeamMemberRepository: JpaRepository<TeamMember, Long> {

    @Query(
        """
            SELECT tm
              FROM TeamMember tm 
              JOIN FETCH Member m
                ON tm.member = m
              JOIN FETCH Team t
                ON tm.team = t
             WHERE t.id = :teamSeq
             ORDER BY tm.id DESC
        """)
    fun findByTeamMember(@Param("teamSeq") teamSeq:Long,
                         pageable: Pageable
    ): Page<TeamMember>
}