package com.study.kopring.member

import com.study.kopring.member.entity.Member
import com.study.kopring.member.repository.MemberRepository
import com.study.kopring.member.vo.request.PMemberAdd
import com.study.kopring.member.vo.response.RMemberAdd
import org.springframework.stereotype.Service

@Service
class MemberServiceImpl(
    private val memberRepository: MemberRepository
): MemberService {

    override fun add(pMemberAdd: PMemberAdd): RMemberAdd {
        val entity:Member = pMemberAdd.toEntity(pMemberAdd.getPassword())
        memberRepository.save(entity)
        return RMemberAdd(
            id = entity.memberId,
            name = entity.name
        )
    }
}