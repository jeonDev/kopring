package com.study.kopring.member.entity

import jakarta.persistence.*
import lombok.Getter

@Getter
@Entity
@Table(name = "MEMBER")
class Member (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_SEQ")
    private val id: Long? = null,

    @Column(name = "ID")
    private var memberId: String? = null,

    @Column(name = "PASSWORD")
    private var password: String? = null,

    @Column(name = "NAME")
    private var name: String? = null
){
}