package com.example.bayu.mamikostest.utils

import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat
import android.widget.ImageView
import com.example.bayu.mamikostest.R
import com.squareup.picasso.Picasso

const val ID_PENULIS = "ID_PENULIS"
const val ID_GENRE = "ID_GENRE"
const val ID_BUKU = "ID_BUKU"

fun ImageView.loadImage(url: String) {
    Picasso.get()
        .load(url)
        .placeholder(ResourcesCompat.getDrawable(resources,R.drawable.ic_launcher_background,null)!!)
        .into(this)
}