package com.study.kopring.pms.member

import com.study.kopring.pms.member.entity.Member
import com.study.kopring.pms.member.repository.MemberRepository
import com.study.kopring.pms.member.vo.request.PMemberAdd
import com.study.kopring.pms.member.vo.response.RMemberAdd
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberServiceImpl(
    private val memberRepository: MemberRepository,
    private val encoder:PasswordEncoder
): MemberService {

    @Transactional
    override fun add(pMemberAdd: PMemberAdd): RMemberAdd {
        val entity: Member = memberRepository.save(
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