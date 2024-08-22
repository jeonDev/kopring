package com.study.kopring.common.vo

class PageResponse<T> (
    val totalCount : Int,
    val list : List<T>
){
}