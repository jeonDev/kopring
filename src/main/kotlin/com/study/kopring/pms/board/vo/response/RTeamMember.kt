package com.study.kopring.pms.board.vo.response

import com.study.kopring.pms.member.vo.response.RMember

class RTeamMember(
    var teamMemberSeq: Long?,
    var team: RTeam?,
    var member: RMember?
) {
}