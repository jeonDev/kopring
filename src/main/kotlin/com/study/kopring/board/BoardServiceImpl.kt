package com.study.kopring.board

import com.study.kopring.board.repository.BoardRepository
import com.study.kopring.board.vo.request.PBoard
import com.study.kopring.board.vo.response.RBoard
import org.springframework.stereotype.Service

@Service
class BoardServiceImpl (
    val boardRepository: BoardRepository
): BoardService {

    override fun set(board: PBoard) {
        boardRepository.save(board.toEntity())
    }

    override fun get(): List<RBoard> {
        return boardRepository.findAll().stream().map { it.toResponse() }.toList()
    }

    override fun get(boardSeq: Long): RBoard {
        return boardRepository.findById(boardSeq)
            .orElseThrow()
            .toResponse()
    }

    override fun update(board: PBoard) {
        val entity = boardRepository.findById(board.boardSeq)
            .orElseThrow()
            .update(board)
        boardRepository.save(entity)
    }

    override fun delete(board: PBoard) {
        val entity = boardRepository.findById(board.boardSeq)
            .orElseThrow()
        boardRepository.delete(entity)
    }
}