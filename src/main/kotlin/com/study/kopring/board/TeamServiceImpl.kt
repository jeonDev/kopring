package com.study.kopring.board

import com.study.kopring.board.repository.TeamRepository
import com.study.kopring.board.vo.request.PTeam
import com.study.kopring.board.vo.response.RTeam
import com.study.kopring.common.vo.PageResponse
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TeamServiceImpl(
    val teamRepository: TeamRepository
): TeamService {

    override fun add(pTeam: PTeam) {
        teamRepository.save(pTeam.toEntity())
    }

    override fun get(pageable:Pageable): PageResponse<RTeam> {
        val result = teamRepository.findAll(pageable)
        return PageResponse(
            totalCount = result.totalPages,
            list       = result.content.stream()
                .map { it.toResponse() }
                .toList()
        )
    }
}