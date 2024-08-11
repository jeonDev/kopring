package com.study.kopring.board

import org.springframework.stereotype.Service
import kotlin.IllegalArgumentException

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

    fun get(boardSeq: Long): List<Board> {
        return this.boardData.filter { item -> item.boardSeq == boardSeq }
    }

    fun update(board: Board) {
        if (!this.boardData.contains(board)) throw IllegalArgumentException("수정할 값이 비어있습니다.")
        this.boardData.remove(board)
        this.boardData.add(board)
    }

    fun delete(board: Board) {
        this.boardData.remove(board)
    }

}