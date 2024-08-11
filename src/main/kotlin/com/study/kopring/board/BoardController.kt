package com.study.kopring.board

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
    fun create(@RequestBody board: Board): String {
        boardService.set(board)
        return "ok"
    }

    @GetMapping("/board")
    fun list(): List<Board> {
        return boardService.get();
    }

    @GetMapping("/board/{boardSeq}")
    fun list(@PathVariable("boardSeq") boardSeq:String): List<Board> {
        return boardService.get(boardSeq.toLong());
    }

    @PutMapping("/board")
    fun update(@RequestBody board: Board) {
        return boardService.update(board);
    }

    @DeleteMapping("/board")
    fun delete(@RequestBody board: Board) {
        return boardService.delete(board)
    }
}