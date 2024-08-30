package com.study.kopring.pms.board.vo.request

import com.study.kopring.pms.board.entity.Board
import com.study.kopring.pms.board.vo.type.WorkType

data class PWork (
    val board: Board,
    val progressRate: Long,
    val writerMemberSeq: Long,
    val managerMemberSeq: Long,
    val workType: WorkType
){
}