package com.example.bayu.mamikostest.ui.detail.penulis

import com.example.bayu.mamikostest.data.response.PenulisDetailResponse
import com.example.bayu.mamikostest.network.repo.PenulisRepo
import com.example.bayu.mamikostest.network.repo.RepoCallBack

class PenulisPresenterDetail(val view:PenulisDetailView, val repo:PenulisRepo){
    fun getPenulisDetail(id:Int){
        repo.getPenulisDetail(id,object : RepoCallBack<PenulisDetailResponse>{
            override fun onDataLoad(data: PenulisDetailResponse) {
                view.showPenulis(data)
            }

            override fun onError(error: Throwable) {
                view.onError(error)
            }

        })
    }
}