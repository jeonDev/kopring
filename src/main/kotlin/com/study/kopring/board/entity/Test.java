package com.study.kopring.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity
public class Test {
    @Id
    private Long testSeq;

    private String test;
}
