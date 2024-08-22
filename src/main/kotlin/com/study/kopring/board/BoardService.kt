package com.study.kopring.board

import com.study.kopring.board.vo.request.PBoard
import com.study.kopring.board.vo.response.RBoard
import com.study.kopring.common.vo.PageResponse
import org.springframework.data.domain.Pageable

interface BoardService {

    fun set(board: PBoard)
    fun get(pageable:Pageable):PageResponse<RBoard>
    fun get(boardSeq: Long):RBoard
    fun update(board: PBoard)
    fun delete(board: PBoard)

}