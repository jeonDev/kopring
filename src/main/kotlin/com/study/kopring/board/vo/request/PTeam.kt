package com.study.kopring.board.vo.request

import com.study.kopring.board.entity.Team

class PTeam (
    var teamName: String?,
){

    fun toEntity():Team {
        return Team(
            teamName = teamName
        )
    }
}