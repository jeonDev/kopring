package com.study.kopring.pms.member

import com.study.kopring.pms.member.vo.request.PMemberAdd
import com.study.kopring.pms.member.vo.response.RMemberAdd

interface MemberService {

    fun add(pMemberAdd: PMemberAdd): RMemberAdd;
}