package com.study.kopring.pms.board

import com.study.kopring.pms.board.vo.request.PWork

interface WorkService {
    fun add(pWork: PWork)
}