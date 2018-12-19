package com.example.bayu.mamikostest.ui.penulis

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.bayu.mamikostest.BuildConfig
import com.example.bayu.mamikostest.R
import com.example.bayu.mamikostest.data.model.PenulisPopular
import com.example.bayu.mamikostest.utils.loadImage
import org.jetbrains.anko.find

class PenulisAdapter(
    private val penulisList: List<PenulisPopular>,
    private val listener: (PenulisPopular) -> Unit
) : RecyclerView.Adapter<PenulisAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_book,p0,false))
    }

    override fun getItemCount() = penulisList.size

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(penulisList[p1],listener)
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val penulisName: TextView = itemView.find(R.id.tv_title_book)
        private val imgPenulis: ImageView = itemView.find(R.id.img_cover)

        fun bind(penulis: PenulisPopular, listener: (PenulisPopular) -> Unit) {
            imgPenulis.loadImage("${BuildConfig.BASE_URL}${penulis.photoUrl}")
            penulisName.text = penulis.name
            itemView.setOnClickListener { listener(penulis) }
        }
    }

}