package com.example.bayu.mamikostest.data.model

import com.google.gson.annotations.SerializedName

data class PenulisPopular(
    val id:Int,
    val name:String,
    @SerializedName("photo_url")
    val photoUrl:String
)