package com.example.bayu.mamikostest.ui.home

import com.example.bayu.mamikostest.data.response.BookGenreResponse
import com.example.bayu.mamikostest.data.response.GenreResponse
import com.example.bayu.mamikostest.network.repo.MainRepo
import com.example.bayu.mamikostest.network.repo.RepoCallBack

class MainPresenter(private val view: MainView, private val mainRepo: MainRepo) {
    fun getGenre() {
        mainRepo.getGenreResource(object : RepoCallBack<GenreResponse> {
            override fun onDataLoad(data: GenreResponse) {
                view.showGenre(data)
            }

            override fun onError(error: Throwable) {
                view.onError(error)
            }

        })
    }

    fun getNewBook(){
        mainRepo.getNewBook(7,object :RepoCallBack<BookGenreResponse>{
            override fun onDataLoad(data: BookGenreResponse) {
                view.showNew(data)
            }

            override fun onError(error: Throwable) {
                view.onError(error)
            }

        })
    }
}