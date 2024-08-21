package com.study.kopring.board

import com.study.kopring.board.entity.Board
import com.study.kopring.board.entity.Comment
import com.study.kopring.board.repository.BoardRepository
import com.study.kopring.board.repository.CommentRepository
import com.study.kopring.board.vo.request.PComment
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
@DisplayName("게시판 댓글 서비스")
class CommentServiceImplTest {

    private val commentRepository:CommentRepository = mock()
    private val boardRepository:BoardRepository = mock()
    private val commentService:CommentService = CommentServiceImpl(commentRepository, boardRepository)

    @Test
    @DisplayName("댓글 조회")
    fun 댓글_조회() {
        `when`(commentRepository.findByBoardId(anyLong()))
            .thenReturn(listOf(Comment()))

        val result = commentService.get(1L)

        assertEquals(result.size, 1)
    }

    @Test
    @DisplayName("댓글 추가")
    fun 댓글_추가() {
        val pComment:PComment = PComment(
            commentSeq = 0L,
            boardSeq = 1L,
            content = "abc"
        )

        `when`(boardRepository.findById(anyLong()))
            .thenReturn(Optional.of(Board()))

        val result = commentService.add(pComment)
        assertEquals(result.content, pComment.content)
    }

}