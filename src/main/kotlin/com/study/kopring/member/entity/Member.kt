package com.study.kopring.member.entity

import jakarta.persistence.*

@Entity
@Table(name = "MEMBER")
class Member (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_SEQ")
    val id: Long? = null,

    @Column(name = "ID", unique = true)
    var memberId: String = "",

    @Column(name = "PASSWORD")
    var password: String = "",

    @Column(name = "NAME")
    var name: String = ""
){
}