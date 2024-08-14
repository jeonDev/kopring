package com.study.kopring.board.vo.request

class PBoard (
    var boardSeq: Long,
    var title: String,
    var content: String
) {


    fun update(board: PBoard) {
        this.title = board.title
        this.content = board.content
    }
}