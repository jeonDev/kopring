package com.study.kopring.pms.board.repository

import com.study.kopring.pms.board.entity.Team
import com.study.kopring.pms.board.entity.TeamMember
import com.study.kopring.pms.member.entity.Member
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.util.Optional

interface TeamMemberRepository: JpaRepository<TeamMember, Long> {

    fun findByTeamAndMember(team: Team, member: Member): Optional<TeamMember>

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