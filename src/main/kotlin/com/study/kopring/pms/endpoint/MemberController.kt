package com.study.kopring.pms.endpoint

import com.study.kopring.pms.member.MemberService
import com.study.kopring.pms.member.vo.request.PMemberAdd
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController (
    private val memberService: MemberService
){

    @PostMapping("/pms/v1/member")
    fun add(@RequestBody pMemberAdd: PMemberAdd): ResponseEntity<Void> {
        memberService.add(pMemberAdd)
        return ResponseEntity.ok().build()
    }
}