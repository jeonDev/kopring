package com.study.kopring.pms.board.vo.request

import com.study.kopring.pms.board.entity.Board
import com.study.kopring.pms.board.entity.Team
import com.study.kopring.pms.board.vo.type.BoardType

class PBoard (
    var boardSeq: Long,
    var title: String,
    var content: String,
    var teamSeq: Long,
    var boardType: BoardType,

    var githubUri: String?
) {


    fun toEntity(team: Team) : Board {
        return Board(
            title = title,
            content = content,
            team = team,
            boardType = boardType,
            refValue = this.getRefValue()
        );
    }

    fun getRefValue(): String? {
        return when(boardType) {
            BoardType.GITHUB_COMMIT -> githubUri
            else -> null
        }
    }
}