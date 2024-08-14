package com.study.kopring.board

import com.study.kopring.board.vo.request.PBoard
import com.study.kopring.board.vo.response.RBoard
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BoardController constructor(private val boardService: BoardService){

    @PostMapping("/board")
    fun create(@RequestBody board: PBoard): String {
        boardService.set(board)
        return "ok"
    }

    @GetMapping("/board")
    fun list(): List<RBoard> {
        return boardService.get();
    }

    @GetMapping("/board/{boardSeq}")
    fun list(@PathVariable("boardSeq") boardSeq:Long): List<RBoard> {
        return boardService.get(boardSeq);
    }

    @PutMapping("/board")
    fun update(@RequestBody board: PBoard) {
        return boardService.update(board);
    }

    @DeleteMapping("/board")
    fun delete(@RequestBody board: PBoard) {
        return boardService.delete(board)
    }
}