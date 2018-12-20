package com.example.bayu.mamikostest.ui.penulis

import android.util.Log
import com.example.bayu.mamikostest.data.response.PenulisPopularResponse
import com.example.bayu.mamikostest.network.repo.PenulisRepo
import com.example.bayu.mamikostest.network.repo.RepoCallBack
import com.google.gson.Gson

class PenulisPresenter(private val view:PenulisView, private val penulisRepo: PenulisRepo) {
    fun getPenulis(){
        penulisRepo.getPenulis(10,object: RepoCallBack<PenulisPopularResponse>{
            override fun onDataLoad(data: PenulisPopularResponse) {
                view.showPenulis(data)
                Log.d("cek penulis : ","${Gson().toJsonTree(data)}")
            }

            override fun onError(error: Throwable) {
                view.onError(error)
            }

        })
    }
}