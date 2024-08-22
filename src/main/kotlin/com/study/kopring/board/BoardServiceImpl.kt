package com.study.kopring.board

import com.study.kopring.board.entity.Board
import com.study.kopring.board.repository.BoardRepository
import com.study.kopring.board.vo.request.PBoard
import com.study.kopring.board.vo.response.RBoard
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BoardServiceImpl (
    val boardRepository: BoardRepository
): BoardService {

    @Transactional
    override fun set(board: PBoard) {
        boardRepository.save(board.toEntity())
    }

    @Transactional(readOnly = true)
    override fun get(): List<RBoard> {
        return boardRepository.findByUseYn("Y").stream()
            .map { it.toResponse() }
            .toList()
    }

    @Transactional(readOnly = true)
    override fun get(boardSeq: Long): RBoard {
        return boardRepository.findById(boardSeq)
            .orElseThrow()
            .toResponse()
    }

    @Transactional
    override fun update(board: PBoard) {
        val entity = boardRepository.findById(board.boardSeq)
            .orElseThrow()
            .update(board)
        boardRepository.save(entity)
    }

    @Transactional
    override fun delete(board: PBoard) {
        val entity:Board = boardRepository.findById(board.boardSeq)
            .orElseThrow()
        entity.delete()
        boardRepository.save(entity)
    }
}