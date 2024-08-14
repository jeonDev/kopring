package com.study.kopring.board

import com.study.kopring.board.vo.request.PBoard
import com.study.kopring.board.vo.response.RBoard
import org.springframework.stereotype.Service

@Service
class BoardServiceImpl : BoardService {

    override fun set(board: PBoard) {
        TODO("Not yet implemented")
    }

    override fun get(): List<RBoard> {
        TODO("Not yet implemented")
    }

    override fun get(boardSeq: Long): List<RBoard> {
        TODO("Not yet implemented")
    }

    override fun update(board: PBoard) {
        TODO("Not yet implemented")
    }

    override fun delete(board: PBoard) {
        TODO("Not yet implemented")
    }
}