package com.example.bayu.mamikostest.network.repo

import com.example.bayu.mamikostest.data.response.BookDetailResponse
import com.example.bayu.mamikostest.data.response.BookGenreResponse
import com.example.bayu.mamikostest.network.ApiService
import com.example.bayu.mamikostest.network.RetrofitService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BukuRepo {
    fun getBuku(callBack: RepoCallBack<BookGenreResponse>) {
        RetrofitService.createService(ApiService::class.java)
            .getBooks()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ data ->
                callBack.onDataLoad(data)
            }, { error ->
                callBack.onError(error)
            })
    }

    fun getBukuByGenre(idGenre: Int, callBack: RepoCallBack<BookGenreResponse>) {
        RetrofitService.createService(ApiService::class.java)
            .getBookByGenre(idGenre)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ data ->
                callBack.onDataLoad(data)
            }, { error ->
                callBack.onError(error)
            })
    }

    fun getBukuDetail(idBuku: Int, callBack: RepoCallBack<BookDetailResponse>) {
        RetrofitService.createService(ApiService::class.java)
            .getBookDetail(idBuku)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ data ->
                callBack.onDataLoad(data)
            }, { error ->
                callBack.onError(error)
            })
    }
}