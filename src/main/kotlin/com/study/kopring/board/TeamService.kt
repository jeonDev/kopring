package com.study.kopring.board

import com.study.kopring.board.vo.request.PTeam
import com.study.kopring.board.vo.response.RTeam
import com.study.kopring.common.vo.PageResponse
import org.springframework.data.domain.Pageable

interface TeamService {

    fun add(pTeam:PTeam)
    fun get(pageable: Pageable):PageResponse<RTeam>
}