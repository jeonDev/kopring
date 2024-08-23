package com.study.kopring.member

import com.study.kopring.member.vo.request.PMemberAdd
import com.study.kopring.member.vo.response.RMemberAdd

interface MemberService {

    fun add(pMemberAdd: PMemberAdd): RMemberAdd;
}