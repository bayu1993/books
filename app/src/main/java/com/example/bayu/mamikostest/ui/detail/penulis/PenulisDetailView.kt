package com.example.bayu.mamikostest.ui.detail.penulis

import com.example.bayu.mamikostest.data.response.PenulisDetailResponse

interface PenulisDetailView{
    fun showPenulis(data: PenulisDetailResponse)
    fun onError(error:Throwable)
}