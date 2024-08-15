package com.study.kopring.board.vo.request

import com.study.kopring.board.entity.Board

class PBoard (
    var boardSeq: Long,
    var title: String,
    var content: String
) {


    fun toEntity() :Board {
        return Board(
            title = title,
            content = content
        );
    }
}