package com.study.kopring.pms.member.impl

import com.study.kopring.pms.member.UserService
import com.study.kopring.pms.member.vo.request.PLogin
import com.study.kopring.pms.member.vo.response.RLogin
import org.springframework.stereotype.Service

@Service
class UserServiceImpl (

): UserService{

    override fun login(pLogin: PLogin): RLogin {
        return RLogin(
            id = "",
            name = ""
        )
    }
}