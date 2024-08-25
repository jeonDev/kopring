package com.study.kopring.pms.board

import com.study.kopring.common.vo.PageResponse
import com.study.kopring.pms.board.vo.request.PTeam
import com.study.kopring.pms.board.vo.response.RTeam
import org.springframework.data.domain.Pageable

interface TeamService {

    fun add(pTeam: PTeam)
    fun get(pageable: Pageable):PageResponse<RTeam>
}