package com.example.bayu.mamikostest.utils

import android.widget.ImageView
import com.example.bayu.mamikostest.BuildConfig
import com.squareup.picasso.Picasso
import io.reactivex.disposables.CompositeDisposable

const val ID_PENULIS = "ID_PENULIS"
const val ID_GENRE = "ID_GENRE"
const val ID_BUKU = "ID_BUKU"

val compositeDisposable = CompositeDisposable()

fun ImageView.loadImage(url: String) {
    Picasso.get()
        .load(url)
        .into(this)
}

fun loadUrl(url: String): String {
    return BuildConfig.BASE_URL + BuildConfig.FILES + url + BuildConfig.API
}