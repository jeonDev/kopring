package com.study.kopring.pms.board.impl

import com.study.kopring.pms.board.WorkService
import com.study.kopring.pms.board.repository.WorkRepository
import com.study.kopring.pms.board.vo.request.PWork
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class WorkServiceImpl(
    private val workRepository: WorkRepository
): WorkService {

    @Transactional
    override fun add(pWork: PWork) {

    }
}