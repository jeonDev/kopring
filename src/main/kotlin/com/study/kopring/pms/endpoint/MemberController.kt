package com.study.kopring.pms.endpoint

import com.study.kopring.pms.member.MemberService
import com.study.kopring.pms.member.UserService
import com.study.kopring.pms.member.vo.request.PLogin
import com.study.kopring.pms.member.vo.request.PMemberAdd
import com.study.kopring.pms.member.vo.response.RLogin
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController (
    private val memberService: MemberService,
    private val userService: UserService
){

    @PostMapping("/pms/v1/member")
    fun add(@RequestBody pMemberAdd: PMemberAdd): ResponseEntity<Void> {
        memberService.add(pMemberAdd)
        return ResponseEntity.noContent().build()
    }

    @PostMapping("/pms/v1/login")
    fun login(@RequestBody pLogin: PLogin): ResponseEntity<RLogin> {
        val login = userService.login(pLogin)
        return ResponseEntity.ok(login)
    }
}