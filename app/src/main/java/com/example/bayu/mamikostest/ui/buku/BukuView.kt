package com.example.bayu.mamikostest.ui.buku

import com.example.bayu.mamikostest.data.response.BookGenreResponse

interface BukuView{
    fun showBook(data: BookGenreResponse)
    fun onError(error:Throwable)
}
