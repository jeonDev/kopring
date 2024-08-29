package com.study.kopring.pms.member.repository

import com.study.kopring.pms.member.entity.Member
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface MemberRepository: JpaRepository<Member, Long> {
    fun findByMemberId(memberId:String): Optional<Member>
}