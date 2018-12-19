package com.example.bayu.mamikostest.ui.buku

import com.example.bayu.mamikostest.data.response.BookGenreResponse
import com.example.bayu.mamikostest.network.repo.BukuRepo
import com.example.bayu.mamikostest.network.repo.RepoCallBack

class BukuPresenter(private val view: BukuView, private val bukuRepo: BukuRepo){
    fun getBooks(){
        bukuRepo.getBuku(object :RepoCallBack<BookGenreResponse>{
            override fun onDataLoad(data: BookGenreResponse) {
                view.showBook(data)
            }

            override fun onError(error: Throwable) {
                view.onError(error)
            }

        })
    }

    fun getBookByGenre(id:Int){
        bukuRepo.getBukuByGenre(id, object :RepoCallBack<BookGenreResponse>{
            override fun onDataLoad(data: BookGenreResponse) {
                view.showBook(data)
            }

            override fun onError(error: Throwable) {
                view.onError(error)
            }

        })
    }
}