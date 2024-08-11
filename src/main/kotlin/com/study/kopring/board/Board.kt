package com.study.kopring.board

class Board (
    var boardSeq: Long,
    var title: String,
    var content: String
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Board

        return boardSeq == other.boardSeq
    }

    override fun hashCode(): Int {
        return javaClass.hashCode()
    }

    fun update(board: Board) {
        this.title = board.title
        this.content = board.content
    }
}