package com.study.kopring.member

import com.study.kopring.member.entity.Member
import com.study.kopring.member.repository.MemberRepository
import com.study.kopring.member.vo.request.PMemberAdd
import com.study.kopring.member.vo.response.RMemberAdd
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class MemberServiceImpl(
    private val memberRepository: MemberRepository,
    private val encoder:PasswordEncoder
): MemberService {

    override fun add(pMemberAdd: PMemberAdd): RMemberAdd {
        val entity:Member = memberRepository.save(
            pMemberAdd.toEntity(
                encoder.encode(pMemberAdd.password)
            )
        )
        return RMemberAdd(
            id = entity.memberId,
            name = entity.name
        )
    }
}