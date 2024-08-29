package com.study.kopring.pms.member.impl

import com.study.kopring.config.exception.ServiceException
import com.study.kopring.config.exception.type.MemberError
import com.study.kopring.pms.member.UserService
import com.study.kopring.pms.member.repository.MemberRepository
import com.study.kopring.pms.member.vo.request.PLogin
import com.study.kopring.pms.member.vo.response.RLogin
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserServiceImpl (
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder
): UserService{

    override fun login(pLogin: PLogin): RLogin {
        val entity = memberRepository.findByMemberId(pLogin.id)
            .orElseThrow { ServiceException(MemberError.NOT_EXISTS) }

        if (!passwordEncoder.matches(pLogin.password, entity.password)) {
            throw ServiceException(MemberError.NOT_MATCH_PASSWORD)
        }

        return RLogin(
            id = entity.memberId,
            name = entity.name
        )
    }
}