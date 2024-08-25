package com.study.kopring.pms.board

import com.study.kopring.common.vo.PageResponse
import com.study.kopring.pms.board.vo.request.PBoard
import com.study.kopring.pms.board.vo.response.RBoard
import org.springframework.data.domain.Pageable

interface BoardService {

    fun set(board: PBoard)
    fun get(pageable:Pageable):PageResponse<RBoard>
    fun get(boardSeq: Long):RBoard
    fun update(board: PBoard)
    fun delete(board: PBoard)

}