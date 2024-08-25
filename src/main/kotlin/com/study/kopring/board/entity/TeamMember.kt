package com.study.kopring.board.entity

import com.study.kopring.board.vo.response.RTeamMember
import com.study.kopring.member.entity.Member
import jakarta.persistence.*

@Entity
@Table(
    name = "TEAM_MEMBER",
    uniqueConstraints = [
        UniqueConstraint(columnNames = ["MEMBER_SEQ", "TEAM_SEQ"])
    ]
)
class TeamMember(

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "TEAM_MEMBER_SEQ")
    val id:Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_SEQ")
    var member:Member? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_SEQ")
    var team:Team? = null

) {

    fun toResponse(): RTeamMember {
        return RTeamMember(
            teamMemberSeq = id,
            team = team?.toResponse(),
            member = member?.toResponse()
        )
    }
}