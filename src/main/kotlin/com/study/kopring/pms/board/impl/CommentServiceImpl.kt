package com.study.kopring.pms.board.impl

import com.study.kopring.config.exception.ServiceException
import com.study.kopring.pms.board.CommentService
import com.study.kopring.pms.board.entity.Board
import com.study.kopring.pms.board.entity.Comment
import com.study.kopring.pms.board.repository.BoardRepository
import com.study.kopring.pms.board.repository.CommentRepository
import com.study.kopring.pms.board.vo.request.PComment
import com.study.kopring.pms.board.vo.response.RComment
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CommentServiceImpl (
    val commentRepository: CommentRepository,
    val boardRepository: BoardRepository
) : CommentService {

    @Transactional(readOnly = true)
    override fun get(boardSeq: Long): List<RComment> {
        return commentRepository.findByBoardId(boardSeq).stream()
            .map { it.toResponse() }
            .toList()
    }

    @Transactional
    override fun add(pComment: PComment): RComment {
        val board: Board = boardRepository.findById(pComment.boardSeq)
            .orElseThrow {
                ServiceException(
                    errorMessage = "No Entity"
                )
            }

        val comment: Comment = Comment(
            board = board,
            content = pComment.content
        )
        commentRepository.save(comment)

        return RComment(
            commentSeq = comment.id,
            content = comment.content
        )
    }
}