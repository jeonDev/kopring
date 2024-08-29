package com.study.kopring.pms.board

import com.study.kopring.pms.board.entity.Team
import com.study.kopring.pms.board.impl.TeamServiceImpl
import com.study.kopring.pms.board.repository.TeamRepository
import com.study.kopring.pms.board.vo.request.PTeam
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable

@ExtendWith(MockitoExtension::class)
@DisplayName("팀 서비스")
class TeamServiceImplTest {

    private val teamRepository: TeamRepository = mock()
    private val teamService:TeamService = TeamServiceImpl(teamRepository)

    @Test
    @DisplayName("팀 추가")
    fun 팀_추가() {
        val pteam: PTeam = PTeam(
            teamName = "ABC"
        )

        assertDoesNotThrow({
            teamService.add(pteam)
        })
    }

    @Test
    @DisplayName("팀 조회")
    fun 팀_조회() {
        val pageable: Pageable = PageRequest.of(0, 10)

        val page: Page<Team> = PageImpl(listOf(Team()))

        Mockito.`when`(teamRepository.findAll(ArgumentMatchers.any(Pageable::class.java)))
            .thenReturn(page)
        val result = teamService.get(pageable)

        assertEquals(result.totalCount, 1)
    }
}