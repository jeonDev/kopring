package com.study.kopring.board

import com.study.kopring.board.repository.TeamMemberRepository
import com.study.kopring.board.repository.TeamRepository
import com.study.kopring.board.vo.request.PTeamMember
import com.study.kopring.board.vo.response.RTeamMember
import com.study.kopring.common.vo.PageResponse
import com.study.kopring.member.repository.MemberRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TeamMemberServiceImpl(
    private val teamMemberRepository: TeamMemberRepository,
    private val teamRepository: TeamRepository,
    private val memberRepository: MemberRepository
):TeamMemberService {

    override fun add(pTeamMember: PTeamMember) {
        val team = teamRepository.findById(pTeamMember.teamSeq)
            .orElseThrow({IllegalArgumentException("No Entity")})

        val member = memberRepository.findById(pTeamMember.memberSeq)
            .orElseThrow({IllegalArgumentException("No Entity")})

        teamMemberRepository.save(pTeamMember.toEntity(
            team = team,
            member = member
        ))
    }

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