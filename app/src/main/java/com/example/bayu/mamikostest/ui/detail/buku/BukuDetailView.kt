package com.example.bayu.mamikostest.ui.detail.buku

import com.example.bayu.mamikostest.data.response.BookDetailResponse

interface BukuDetailView{
    fun showBuku(data: BookDetailResponse)
    fun onError(error:Throwable)
}