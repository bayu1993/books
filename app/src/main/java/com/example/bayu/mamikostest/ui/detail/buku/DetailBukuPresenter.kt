package com.example.bayu.mamikostest.ui.detail.buku

import com.example.bayu.mamikostest.data.response.BookDetailResponse
import com.example.bayu.mamikostest.network.repo.BukuRepo
import com.example.bayu.mamikostest.network.repo.RepoCallBack

class DetailBukuPresenter(
    private val view: BukuDetailView,
    private val repo: BukuRepo
) {
    fun getDetailBook(idBuku:Int){
        repo.getBukuDetail(idBuku,object :RepoCallBack<BookDetailResponse>{
            override fun onDataLoad(data: BookDetailResponse) {
                view.showBuku(data)
            }

            override fun onError(error: Throwable) {
                view.onError(error)
            }

        })
    }
}