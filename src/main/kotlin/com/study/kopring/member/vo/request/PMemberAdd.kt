package com.study.kopring.member.vo.request

import com.study.kopring.member.entity.Member

class PMemberAdd (
    var id:String,
    var password: String,
    var name: String
){

    fun toEntity(encPassword: String) :Member {
        return Member(
            memberId = id,
            password = encPassword,
            name = name,
        )
    }
}