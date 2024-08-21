package com.study.kopring.board.entity

import com.study.kopring.board.vo.request.PBoard
import com.study.kopring.board.vo.response.RBoard
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "BOARD")
@Entity
class Board (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_SEQ")
    val id:Long? = null,

    @Column(name = "TITLE")
    var title:String? = null,

    @Column(name = "CONTENT")
    var content:String? = null,

    @Column(name = "USE_YN")
    var useYn:String = "Y"
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
            useYn = useYn
        )
    }

}