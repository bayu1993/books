package com.example.bayu.mamikostest.network.repo

import com.example.bayu.mamikostest.data.response.BookGenreResponse
import com.example.bayu.mamikostest.data.response.GenreResponse
import com.example.bayu.mamikostest.network.ApiService
import com.example.bayu.mamikostest.network.RetrofitService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainRepo(private val compositeDisposable: CompositeDisposable){
    private lateinit var dispose:Disposable
    fun getGenreResource(callBack: RepoCallBack<GenreResponse>){
       dispose =  RetrofitService.createService(ApiService::class.java)
            .getGenre()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                data -> callBack.onDataLoad(data)
            },{
                error -> callBack.onError(error)
            })
        compositeDisposable.add(dispose)

    }

    fun getNewBook(limit:Int,callBack: RepoCallBack<BookGenreResponse>){
        dispose = RetrofitService.createService(ApiService::class.java)
            .getNewBook(limit)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                data -> callBack.onDataLoad(data)
            },{
                error -> callBack.onError(error)
            })
        compositeDisposable.add(dispose)
    }
}