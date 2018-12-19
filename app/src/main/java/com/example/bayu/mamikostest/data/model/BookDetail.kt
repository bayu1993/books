package com.example.bayu.mamikostest.data.model

data class BookDetail(
    val id:Int,
    val title:String,
    val synopsis:String,
    val cover_url:String,
    val full_price:String,
    val desc:String,
    val genres:List<GenreModel>
)