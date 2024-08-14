package com.study.kopring.board

import com.study.kopring.board.vo.request.PBoard
import com.study.kopring.board.vo.response.RBoard

interface BoardService {

    fun set(board: PBoard)
    fun get():List<RBoard>
    fun get(boardSeq: Long):List<RBoard>
    fun update(board: PBoard)
    fun delete(board: PBoard)

}