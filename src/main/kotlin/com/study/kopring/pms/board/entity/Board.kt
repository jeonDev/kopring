package com.study.kopring.pms.board.entity

import com.study.kopring.pms.board.vo.request.PBoard
import com.study.kopring.pms.board.vo.response.GithubCommitHistory
import com.study.kopring.pms.board.vo.response.RBoard
import com.study.kopring.pms.board.vo.type.BoardType
import jakarta.persistence.*

@Table(name = "BOARD")
@Entity
class Board (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_SEQ")
    val id:Long? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_SEQ")
    var team: Team? = null,

    @Column(name = "TITLE")
    var title:String? = null,

    @Column(name = "CONTENT")
    var content:String? = null,

    @Column(name = "USE_YN")
    var useYn:String = "Y",

    @Enumerated(EnumType.STRING)
    @Column(name = "BOARD_TYPE")
    var boardType: BoardType? = null,

    @Column(name = "REF_VALUE")
    var refValue: String? = null
){

    fun update(board: PBoard) :Board{
        this.title = board.title
        this.content = board.content
        return this
    }

    fun delete(): Board {
        this.useYn = "N"
        return this
    }

    fun toResponse() :RBoard{
        return RBoard(
            boardSeq = id,
            title = title,
            content = content,
            useYn = useYn,
            boardType = boardType
        )
    }

    fun toResponse(githubCommitHistory: GithubCommitHistory) :RBoard{
        return RBoard(
            boardSeq = id,
            title = title,
            content = content,
            useYn = useYn,
            boardType = boardType,
            githubCommitHistory = githubCommitHistory
        )
    }

}