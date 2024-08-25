package com.study.kopring.pms.board

import com.study.kopring.common.vo.PageResponse
import com.study.kopring.config.exception.ServiceException
import com.study.kopring.pms.board.repository.TeamMemberRepository
import com.study.kopring.pms.board.repository.TeamRepository
import com.study.kopring.pms.board.vo.request.PTeamMember
import com.study.kopring.pms.board.vo.response.RTeamMember
import com.study.kopring.pms.member.repository.MemberRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TeamMemberServiceImpl(
    private val teamMemberRepository: TeamMemberRepository,
    private val teamRepository: TeamRepository,
    private val memberRepository: MemberRepository
):TeamMemberService {

    @Transactional
    override fun add(pTeamMember: PTeamMember) {
        val team = teamRepository.findById(pTeamMember.teamSeq)
            .orElseThrow {
                ServiceException(
                    errorMessage = "No Entity"
                )
            }

        val member = memberRepository.findById(pTeamMember.memberSeq)
            .orElseThrow {
                ServiceException(
                    errorMessage = "No Entity"
                )
            }

        teamMemberRepository.findByTeamAndMember(team, member)
            .ifPresent { throw ServiceException(errorMessage = "이미 등록된 데이터입니다.") }

        teamMemberRepository.save(pTeamMember.toEntity(
            team = team,
            member = member
        ))
    }

    @Transactional(readOnly = true)
    override fun get(pageable: Pageable, teamSeq:Long): PageResponse<RTeamMember> {
        val result = teamMemberRepository.findByTeamMember(teamSeq, pageable)
        return PageResponse(
            totalCount = result.totalPages,
            list = result.content.stream()
                .map { it.toResponse() }
                .toList()
        )
    }
}