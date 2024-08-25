package com.study.kopring.pms.board

import com.study.kopring.common.vo.PageResponse
import com.study.kopring.config.exception.ServiceException
import com.study.kopring.pms.board.entity.Board
import com.study.kopring.pms.board.entity.Team
import com.study.kopring.pms.board.repository.BoardRepository
import com.study.kopring.pms.board.repository.TeamRepository
import com.study.kopring.pms.board.vo.request.PBoard
import com.study.kopring.pms.board.vo.response.RBoard
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BoardServiceImpl (
    val boardRepository: BoardRepository,
    val teamRepository: TeamRepository
): BoardService {
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @Transactional
    override fun set(board: PBoard) {
        val team:Team = teamRepository.findById(board.teamSeq)
            .orElseThrow {
                ServiceException(
                    errorMessage = "No Entity"
                )
            }
        boardRepository.save(board.toEntity(team))
    }

    @Transactional(readOnly = true)
    override fun get(pageable: Pageable): PageResponse<RBoard> {
        val result = boardRepository.findByUseYnOrderByIdDesc(pageable, "Y");
        return PageResponse(
            totalCount = result.totalPages,
            list       = result.content.stream()
                .map { it.toResponse() }
                .toList()
        )
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