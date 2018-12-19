package com.example.bayu.mamikostest.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.bayu.mamikostest.BuildConfig
import com.example.bayu.mamikostest.R
import com.example.bayu.mamikostest.data.model.BookGenreModel
import com.example.bayu.mamikostest.utils.loadImage
import org.jetbrains.anko.find

class HomeBookAdapter(
    private val bookList: List<BookGenreModel>,
    private val listener: (BookGenreModel) -> Unit
) : RecyclerView.Adapter<HomeBookAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_book, p0, false))
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(bookList[p1],listener)
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val imgCover = itemView.find<ImageView>(R.id.img_cover)
        private val tvTitle = itemView.find<TextView>(R.id.tv_title_book)
        fun bind(newBook:BookGenreModel, listener: (BookGenreModel) -> Unit){
            imgCover.loadImage("${BuildConfig.BASE_URL}${newBook.cover_url}")
            tvTitle.text = newBook.title
            itemView.setOnClickListener { listener(newBook) }
        }
    }
}