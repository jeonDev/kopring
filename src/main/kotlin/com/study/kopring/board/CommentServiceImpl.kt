package com.study.kopring.board

import com.study.kopring.board.entity.Board
import com.study.kopring.board.entity.Comment
import com.study.kopring.board.repository.BoardRepository
import com.study.kopring.board.repository.CommentRepository
import com.study.kopring.board.vo.request.PComment
import com.study.kopring.board.vo.response.RComment
import org.springframework.stereotype.Service

@Service
class CommentServiceImpl (
    val commentRepository: CommentRepository,
    val boardRepository: BoardRepository
) :CommentService{

    override fun get(): List<RComment> {
        return commentRepository.findAll().stream()
            .map { it.toResponse() }
            .toList()
    }

    override fun add(pComment: PComment): RComment {
        val board:Board = boardRepository.findById(pComment.boardSeq)
            .orElseThrow { IllegalArgumentException("No Entity") }

        val comment:Comment = Comment(
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