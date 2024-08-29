package com.study.kopring.pms.board

import com.study.kopring.config.exception.ServiceException
import com.study.kopring.pms.board.entity.Team
import com.study.kopring.pms.board.entity.TeamMember
import com.study.kopring.pms.board.impl.TeamMemberServiceImpl
import com.study.kopring.pms.board.repository.TeamMemberRepository
import com.study.kopring.pms.board.repository.TeamRepository
import com.study.kopring.pms.board.vo.request.PTeamMember
import com.study.kopring.pms.member.entity.Member
import com.study.kopring.pms.member.repository.MemberRepository
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import java.util.*

@ExtendWith(MockitoExtension::class)
@DisplayName("팀 고객 서비스")
class TeamMemberServiceImplTest {
    private val teamMemberRepository:TeamMemberRepository = mock()
    private val teamRepository:TeamRepository = mock()
    private val memberRepository:MemberRepository = mock()
    private val teamMemberService:TeamMemberService = TeamMemberServiceImpl(teamMemberRepository, teamRepository, memberRepository)

    private fun <T> any() : T{
        Mockito.any<T>()
        return null as T
    }

    @Test
    @DisplayName("고객 추가 성공")
    fun 고객_추가() {
        val pTeamMember = PTeamMember(
            memberSeq = 1L,
            teamSeq = 1L
        )

        `when`(teamRepository.findById(anyLong()))
            .thenReturn(Optional.of(Team()))

        `when`(memberRepository.findById(anyLong()))
            .thenReturn(Optional.of(Member()))

        `when`(teamMemberRepository.findByTeamAndMember(this.any(), this.any()))
            .thenReturn(Optional.empty())

        assertDoesNotThrow {
            teamMemberService.add(pTeamMember)
        }
    }

    @Test
    @DisplayName("고객 추가 고객정보 없음")
    fun 고객_추가_고객정보_없음() {
        val pTeamMember = PTeamMember(
            memberSeq = 1L,
            teamSeq = 1L
        )

        `when`(teamRepository.findById(anyLong()))
            .thenReturn(Optional.of(Team()))

        `when`(memberRepository.findById(anyLong()))
            .thenReturn(Optional.empty())

        assertThrows(ServiceException::class.java) {
            teamMemberService.add(pTeamMember)
        }
    }

    @Test
    @DisplayName("고객 추가 팀 정보 없음")
    fun 고객_추가_팀정보_없음() {
        val pTeamMember = PTeamMember(
            memberSeq = 1L,
            teamSeq = 1L
        )

        `when`(teamRepository.findById(anyLong()))
            .thenReturn(Optional.empty())

        assertThrows(ServiceException::class.java) {
            teamMemberService.add(pTeamMember)
        }
    }

    @Test
    @DisplayName("고객 추가 이미 정보 있음")
    fun 고객_추가_이미_존재() {
        val pTeamMember = PTeamMember(
            memberSeq = 1L,
            teamSeq = 1L
        )

        `when`(teamRepository.findById(anyLong()))
            .thenReturn(Optional.of(Team()))

        `when`(memberRepository.findById(anyLong()))
            .thenReturn(Optional.of(Member()))

        `when`(teamMemberRepository.findByTeamAndMember(this.any(), this.any()))
            .thenReturn(Optional.of(TeamMember()))

        assertThrows(ServiceException::class.java) {
            teamMemberService.add(pTeamMember)
        }
    }

    @Test
    @DisplayName("고객 조회")
    fun 고객_조회() {
        val pageable: Pageable = PageRequest.of(0, 10)
        val page: Page<TeamMember> = PageImpl(listOf(TeamMember()))

        `when`(teamMemberRepository.findByTeamMember(anyLong(), this.any()))
            .thenReturn(page)
        val result = teamMemberService.get(pageable, 1L)
        assertEquals(result.totalCount, 1)
    }
}