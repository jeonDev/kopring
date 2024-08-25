package com.study.kopring.pms.member.repository

import com.study.kopring.pms.member.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member, Long> {
}