package com.study.kopring.pms.board.vo.request

import com.study.kopring.pms.board.entity.Team
import com.study.kopring.pms.board.entity.TeamMember
import com.study.kopring.pms.member.entity.Member

class PTeamMember(
    var teamSeq: Long,
    var memberSeq: Long
) {
    fun toEntity(team: Team, member: Member): TeamMember {
        return TeamMember(
            team = team,
            member = member
        )
    }
}