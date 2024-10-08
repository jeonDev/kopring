package com.study.kopring.pms.board.impl

import com.study.kopring.common.vo.PageResponse
import com.study.kopring.config.exception.ServiceException
import com.study.kopring.pms.board.BoardService
import com.study.kopring.pms.board.GithubService
import com.study.kopring.pms.board.WorkService
import com.study.kopring.pms.board.entity.Board
import com.study.kopring.pms.board.entity.Team
import com.study.kopring.pms.board.repository.BoardRepository
import com.study.kopring.pms.board.repository.TeamRepository
import com.study.kopring.pms.board.vo.request.PBoard
import com.study.kopring.pms.board.vo.request.PWork
import com.study.kopring.pms.board.vo.response.RBoard
import com.study.kopring.pms.board.vo.type.BoardType
import com.study.kopring.pms.board.vo.type.WorkType
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class BoardServiceImpl (
    val boardRepository: BoardRepository,
    val teamRepository: TeamRepository,
    val githubService: GithubService,
    val workService: WorkService
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
        val entity = boardRepository.save(board.toEntity(team))

        if (board.boardType == BoardType.WORK) {
            workService.add(PWork(
                board = entity,
                // TODO: 파라미터 세팅
                progressRate = 0L,
                writerMemberSeq = 0L,
                managerMemberSeq = 0L,
                workType = WorkType.REQUEST
            ))
        }
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
        val result = boardRepository.findById(boardSeq)
            .orElseThrow()

        if (result.boardType == BoardType.GITHUB_COMMIT) {
            try {
                return result
                    .toResponse(githubService.getApiCall(result.refValue!!))
            } catch (e: Exception) {
                logger.error("GitHub 통신 오류", e)
            }
        }

        return result
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