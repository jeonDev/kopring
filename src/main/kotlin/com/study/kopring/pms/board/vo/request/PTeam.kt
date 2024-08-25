package com.study.kopring.pms.board.vo.request

import com.study.kopring.pms.board.entity.Team

class PTeam (
    var teamName: String?,
){

    fun toEntity(): Team {
        return Team(
            teamName = teamName
        )
    }
}