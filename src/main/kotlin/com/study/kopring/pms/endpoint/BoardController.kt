package com.study.kopring.pms.endpoint

import com.study.kopring.pms.board.BoardService
import com.study.kopring.common.vo.PageResponse
import com.study.kopring.pms.board.vo.request.PBoard
import com.study.kopring.pms.board.vo.response.RBoard
import org.springframework.data.domain.PageRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class BoardController(
    private val boardServiceImpl: BoardService,
){

    @PostMapping("/pms/v1/board")
    fun create(@RequestBody board: PBoard): ResponseEntity<Void> {
        boardServiceImpl.set(board)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/pms/v1/board")
    fun list(@RequestParam("size", defaultValue = "10") size:Int,
             @RequestParam("page", defaultValue = "0") page:Int
             ): ResponseEntity<PageResponse<RBoard>> {
        val result = boardServiceImpl.get(PageRequest.of(page, size))
        return ResponseEntity.ok().body(result)
    }

    @GetMapping("/pms/v1/board/{boardSeq}")
    fun list(@PathVariable("boardSeq") boardSeq:Long): ResponseEntity<RBoard> {
        val result = boardServiceImpl.get(boardSeq)
        return ResponseEntity.ok().body(result)

    }

    @PutMapping("/pms/v1/board")
    fun update(@RequestBody board: PBoard): ResponseEntity<Void> {
        boardServiceImpl.update(board)
        return ResponseEntity.ok().build()
    }

    @DeleteMapping("/pms/v1/board")
    fun delete(@RequestBody board: PBoard): ResponseEntity<Void> {
        boardServiceImpl.delete(board)
        return ResponseEntity.ok().build()

    }
}