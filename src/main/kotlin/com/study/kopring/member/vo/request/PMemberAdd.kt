package com.study.kopring.member.vo.request

import com.study.kopring.member.entity.Member

class PMemberAdd (
    private var id:String,
    private var password: String,
    private var name: String
){

    fun getPassword():String {
        return password;
    }

    fun toEntity(encPassword: String) :Member {
        return Member(
            memberId = id,
            password = encPassword,
            name = name,
        )
    }
}