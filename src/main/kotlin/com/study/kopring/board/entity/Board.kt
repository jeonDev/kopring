package com.study.kopring.board.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Table(name = "BOARD")
@Entity
class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_SEQ")
    var id:Long? = null

    @Column(name = "TITLE")
    var title:String? = null

    @Column(name = "CONTENT")
    var content:String? = null

}