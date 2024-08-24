package com.study.kopring.board

import com.study.kopring.board.vo.request.PTeamMember
import com.study.kopring.board.vo.response.RTeamMember
import com.study.kopring.common.vo.PageResponse
import org.springframework.data.domain.Pageable

interface TeamMemberService {

    fun add(pTeamMember: PTeamMember)
    fun get(pageable: Pageable):PageResponse<RTeamMember>
}