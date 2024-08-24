package com.study.kopring.board.vo.response

import com.study.kopring.member.vo.response.RMember

class RTeamMember(
    var teamMemberSeq: Long?,
    var team: RTeam?,
    var member: RMember?
) {
}