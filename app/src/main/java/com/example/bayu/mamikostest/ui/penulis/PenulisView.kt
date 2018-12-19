package com.example.bayu.mamikostest.ui.penulis

import com.example.bayu.mamikostest.data.response.PenulisPopularResponse

interface PenulisView {
    fun showPenulis(data: PenulisPopularResponse)
    fun onError(error:Throwable)
}