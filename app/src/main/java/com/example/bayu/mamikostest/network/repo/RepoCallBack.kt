package com.example.bayu.mamikostest.network.repo

interface RepoCallBack<T>{
    fun onDataLoad(data:T)
    fun onError(error:Throwable)
}