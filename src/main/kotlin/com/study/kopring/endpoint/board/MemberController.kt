package com.study.kopring.endpoint.board

import com.study.kopring.member.MemberService
import com.study.kopring.member.vo.request.PMemberAdd
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController (
    private val memberService: MemberService
){

    @PostMapping("/v1/member")
    fun add(@RequestBody pMemberAdd: PMemberAdd) {
        memberService.add(pMemberAdd)
    }
}