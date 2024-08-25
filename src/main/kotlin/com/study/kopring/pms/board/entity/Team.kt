package com.study.kopring.pms.board.entity

import com.study.kopring.pms.board.vo.response.RTeam
import jakarta.persistence.*

@Entity
@Table(name = "TEAM")
class Team (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TEAM_SEQ")
    val id:Long? = null,

    @Column(name = "TEAM_NAME")
    val teamName: String? = null
){

    fun toResponse(): RTeam {
        return RTeam(
            teamSeq = id,
            teamName = teamName
        )
    }
}