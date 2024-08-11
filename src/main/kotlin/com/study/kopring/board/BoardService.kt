package com.study.kopring.board

import org.springframework.stereotype.Service

@Service
class BoardService {

    private val boardData = mutableSetOf<Board>()

    fun set(board:Board) {
        val maxBoardSeq = boardData.maxByOrNull { it.boardSeq }
        val nextBoardSeq:Long = (maxBoardSeq?.boardSeq ?: 0) + 1
        board.boardSeq = nextBoardSeq
        boardData.add(board)
    }

    fun get(): List<Board> {
        return this.boardData.toList()
    }

}