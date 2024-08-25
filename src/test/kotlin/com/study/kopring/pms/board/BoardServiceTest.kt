package com.study.kopring.pms.board

import com.study.kopring.pms.board.entity.Board
import com.study.kopring.pms.board.entity.Team
import com.study.kopring.pms.board.repository.BoardRepository
import com.study.kopring.pms.board.repository.TeamRepository
import com.study.kopring.pms.board.vo.request.PBoard
import com.study.kopring.pms.board.vo.type.BoardType
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers.any
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import java.util.*

@ExtendWith(MockitoExtension::class)
@DisplayName("게시판 서비스")
class BoardServiceTest {

    private val boardRepository: BoardRepository = mock()
    private val teamRepository: TeamRepository = mock()

    private val boardService: BoardService =
        BoardServiceImpl(boardRepository, teamRepository)

    private fun <T> any() : T{
        Mockito.any<T>()
        return null as T
    }

    @Test
    @DisplayName("게시글 저장")
    fun 게시글_저장() {
        var pBoard: PBoard = PBoard(
            boardSeq = 0L,
            title = "테스트",
            content = "테스트",
            teamSeq = 1L,
            boardType = BoardType.WIKI
        )
        `when`(teamRepository.findById(anyLong()))
            .thenReturn(Optional.of(Team()))

        assertDoesNotThrow({
            boardService.set(pBoard)
        })
    }

    @Test
    @DisplayName("게시글 조회")
    fun 게시글_조회() {

        val page: Page<Board> = PageImpl(listOf(Board()))
        `when`(boardRepository.findByUseYnOrderByIdDesc(any(), anyString()))
            .thenReturn(page)

        val pageable:Pageable = PageRequest.of(0, 10)
        val result = boardService.get(pageable)

        assertEquals(result.totalCount, 1)
    }

    @Test
    @DisplayName("게시글 단 건 조회")
    fun 게시글_단건_조회() {
        val board = Board(
            title = "aaa",
            content = "bbb",
            boardType = BoardType.WIKI
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
            content = "테스트",
            teamSeq = 1L,
            boardType = BoardType.WIKI
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
            content = "테스트",
            teamSeq = 0L,
            boardType = BoardType.WIKI
        )

        `when`(boardRepository.findById(anyLong()))
            .thenReturn(Optional.of(Board()))

        assertDoesNotThrow({
            boardService.delete(pBoard)
        })
    }

}