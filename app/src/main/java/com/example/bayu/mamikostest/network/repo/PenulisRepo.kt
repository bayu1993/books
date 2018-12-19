package com.example.bayu.mamikostest.network.repo

import com.example.bayu.mamikostest.data.response.BookDetailResponse
import com.example.bayu.mamikostest.data.response.PenulisDetailResponse
import com.example.bayu.mamikostest.data.response.PenulisPopularResponse
import com.example.bayu.mamikostest.network.ApiService
import com.example.bayu.mamikostest.network.RetrofitService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PenulisRepo{
    fun getPenulis(limit:Int, callBack: RepoCallBack<PenulisPopularResponse>){
        RetrofitService.createService(ApiService::class.java)
            .getPenulisPopular(limit)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    data -> callBack.onDataLoad(data)
            },{
                    error -> callBack.onError(error)
            })
    }

    fun getPenulisDetail(idPenulis:Int, callBack: RepoCallBack<PenulisDetailResponse>){
        RetrofitService.createService(ApiService::class.java)
            .getPenulisDetail(idPenulis)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                    data -> callBack.onDataLoad(data)
            },{
                    error -> callBack.onError(error)
            })
    }
}