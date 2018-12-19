package com.example.bayu.mamikostest.data.model

import com.google.gson.annotations.SerializedName

data class PenulisDetail(
    val id:Int,
    val name:String,
    val username:String,
    val email:String,
    @SerializedName("photo_url")
    val photoUrl:String,
    val phone:String
)