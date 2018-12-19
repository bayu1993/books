package com.example.bayu.mamikostest.network.repo

import com.example.bayu.mamikostest.data.response.PenulisDetailResponse
import com.example.bayu.mamikostest.data.response.PenulisPopularResponse
import com.example.bayu.mamikostest.network.ApiService
import com.example.bayu.mamikostest.network.RetrofitService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class PenulisRepo(private val compositeDisposable: CompositeDisposable){
    private lateinit var dispose:Disposable
    fun getPenulis(limit:Int, callBack: RepoCallBack<PenulisPopularResponse>){
        dispose = RetrofitService.createService(ApiService::class.java)
            .getPenulisPopular(limit)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    data -> callBack.onDataLoad(data)
            },{
                    error -> callBack.onError(error)
            })
        compositeDisposable.add(dispose)
    }

    fun getPenulisDetail(idPenulis:Int, callBack: RepoCallBack<PenulisDetailResponse>){
        dispose = RetrofitService.createService(ApiService::class.java)
            .getPenulisDetail(idPenulis)
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