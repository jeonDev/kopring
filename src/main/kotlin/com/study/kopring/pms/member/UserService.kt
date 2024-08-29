package com.study.kopring.pms.member

import com.study.kopring.pms.member.vo.request.PLogin
import com.study.kopring.pms.member.vo.response.RLogin

interface UserService {

    fun login(pLogin: PLogin):RLogin

}