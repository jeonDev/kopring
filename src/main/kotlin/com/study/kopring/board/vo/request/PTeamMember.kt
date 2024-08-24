package com.study.kopring.board.vo.request

import com.study.kopring.board.entity.Team
import com.study.kopring.board.entity.TeamMember
import com.study.kopring.member.entity.Member

class PTeamMember(
    var teamSeq: Long,
    var memberSeq: Long
) {
    fun toEntity(team:Team, member:Member):TeamMember {
        return TeamMember(
            team = team,
            member = member
        )
    }
}