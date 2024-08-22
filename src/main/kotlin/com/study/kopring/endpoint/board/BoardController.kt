package com.study.kopring.endpoint.board

import com.study.kopring.board.BoardService
import com.study.kopring.board.vo.request.PBoard
import com.study.kopring.board.vo.response.RBoard
import com.study.kopring.common.vo.PageResponse
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class BoardController constructor(private val boardServiceImpl: BoardService){

    @PostMapping("/board")
    fun create(@RequestBody board: PBoard): String {
        boardServiceImpl.set(board)
        return "ok"
    }

    @GetMapping("/board")
    fun list(@RequestParam("size", defaultValue = "10") size:Int,
             @RequestParam("page", defaultValue = "0") page:Int
             ): PageResponse<RBoard> {
        return boardServiceImpl.get(PageRequest.of(page, size));
    }

    @GetMapping("/board/{boardSeq}")
    fun list(@PathVariable("boardSeq") boardSeq:Long): RBoard {
        return boardServiceImpl.get(boardSeq);
    }

    @PutMapping("/board")
    fun update(@RequestBody board: PBoard) {
        return boardServiceImpl.update(board);
    }

    @DeleteMapping("/board")
    fun delete(@RequestBody board: PBoard) {
        return boardServiceImpl.delete(board)
    }
}