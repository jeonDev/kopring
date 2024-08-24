package com.study.kopring.board.vo.request

import com.study.kopring.board.entity.Board
import com.study.kopring.board.entity.Team

class PBoard (
    var boardSeq: Long,
    var title: String,
    var content: String,
    var teamSeq: Long
) {


    fun toEntity(team:Team) :Board {
        return Board(
            title = title,
            content = content,
            team = team
        );
    }
}