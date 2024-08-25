package com.study.kopring.pms.member

import com.study.kopring.pms.member.entity.Member
import com.study.kopring.pms.member.repository.MemberRepository
import com.study.kopring.pms.member.vo.request.PMemberAdd
import com.study.kopring.pms.member.vo.response.RMemberAdd
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.security.crypto.password.PasswordEncoder

@ExtendWith(MockitoExtension::class)
@DisplayName("고객 서비스")
class MemberServiceImplTest {
    private val memberRepository:MemberRepository = mock()
    private val passwordEncoder:PasswordEncoder = mock()
    private val memberService:MemberService = MemberServiceImpl(memberRepository, passwordEncoder)

    @Test
    @DisplayName("고객 등록 성공")
    fun 고객_등록() {
        val pMemberAdd: PMemberAdd = PMemberAdd(
            id = "test",
            name = "테스트",
            password = "1234"
        )
        `when`(memberRepository.save(any()))
            .thenAnswer { invocation ->
                val member = invocation.arguments[0] as Member
                member
            }

        `when`(passwordEncoder.encode(anyString()))
            .thenReturn("1234")

        val result:RMemberAdd = memberService.add(pMemberAdd)
        assertEquals(result.id, pMemberAdd.id)
        assertEquals(result.name, pMemberAdd.name)
    }
}