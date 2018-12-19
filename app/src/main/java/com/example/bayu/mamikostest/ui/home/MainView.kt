package com.example.bayu.mamikostest.ui.home

import com.example.bayu.mamikostest.data.response.BookGenreResponse
import com.example.bayu.mamikostest.data.response.GenreResponse

interface MainView {
    fun showNew(data: BookGenreResponse)
    fun showGenre(data:GenreResponse)
    fun onError(error:Throwable)
}