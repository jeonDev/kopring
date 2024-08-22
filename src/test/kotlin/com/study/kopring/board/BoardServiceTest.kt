package com.study.kopring.board

import com.study.kopring.board.entity.Board
import com.study.kopring.board.repository.BoardRepository
import com.study.kopring.board.vo.request.PBoard
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
@DisplayName("게시판 서비스")
class BoardServiceTest {

    private val boardRepository: BoardRepository = mock()

    private val boardService: BoardService =
        BoardServiceImpl(boardRepository)

    @Test
    @DisplayName("게시글 저장")
    fun 게시글_저장() {
        var pBoard:PBoard = PBoard(
            boardSeq = 0L,
            title = "테스트",
            content = "테스트"
        )

        assertDoesNotThrow({
            boardService.set(pBoard)
        })
    }

    @Test
    @DisplayName("게시글 조회")
    fun 게시글_조회() {
        `when`(boardRepository.findByUseYn(anyString()))
            .thenReturn(listOf(Board()))

        val result = boardService.get()

        assertEquals(result.size, 1)
    }

    @Test
    @DisplayName("게시글 단 건 조회")
    fun 게시글_단건_조회() {
        val board = Board(
            title = "aaa",
            content = "bbb"
        )
        `when`(boardRepository.findById(anyLong()))
            .thenReturn(Optional.of(board))

        val result = boardService.get(1L)

        assertEquals(result.title, board.toResponse().title)
        assertEquals(result.content, board.toResponse().content)
    }

    @Test
    @DisplayName("게시글 수정")
    fun update() {
        var pBoard:PBoard = PBoard(
            boardSeq = 1L,
            title = "테스트",
            content = "테스트"
        )

        `when`(boardRepository.findById(anyLong()))
            .thenReturn(Optional.of(Board()))

        assertDoesNotThrow({
            boardService.update(pBoard)
        })
    }

    @Test
    @DisplayName("게시글 삭제")
    fun delete() {
        var pBoard:PBoard = PBoard(
            boardSeq = 1L,
            title = "테스트",
            content = "테스트"
        )

        `when`(boardRepository.findById(anyLong()))
            .thenReturn(Optional.of(Board()))

        assertDoesNotThrow({
            boardService.delete(pBoard)
        })
    }

}