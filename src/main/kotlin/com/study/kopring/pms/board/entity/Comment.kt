package com.study.kopring.pms.board.entity

import com.study.kopring.pms.board.vo.response.RComment
import jakarta.persistence.*

@Table(name = "COMMENT")
@Entity
class Comment (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_SEQ")
    val id:Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BOARD_SEQ")
    var board:Board? = null,

    @Column(name = "CONTENT")
    var content:String? = null
){

    fun toResponse() : RComment {
        return RComment(
            commentSeq = id,
            content = content
        )
    }

}