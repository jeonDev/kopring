package com.study.kopring.endpoint.board

import com.study.kopring.member.MemberService
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController (private val memberService: MemberService){
}