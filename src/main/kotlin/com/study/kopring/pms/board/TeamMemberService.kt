package com.study.kopring.pms.board

import com.study.kopring.common.vo.PageResponse
import com.study.kopring.pms.board.vo.request.PTeamMember
import com.study.kopring.pms.board.vo.response.RTeamMember
import org.springframework.data.domain.Pageable

interface TeamMemberService {

    fun add(pTeamMember: PTeamMember)
    fun get(pageable: Pageable, teamSeq: Long):PageResponse<RTeamMember>
}