package com.example.bayu.mamikostest.ui.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.bayu.mamikostest.R
import com.example.bayu.mamikostest.data.model.GenreModel
import org.jetbrains.anko.find

class HomeGenreAdapter(
    private val genreList: List<GenreModel>,
    private val listener: (GenreModel) -> Unit
) : RecyclerView.Adapter<HomeGenreAdapter.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HomeGenreAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.item_genre, p0, false))
    }

    override fun getItemCount(): Int {
        return genreList.size
    }

    override fun onBindViewHolder(p0: HomeGenreAdapter.ViewHolder, p1: Int) {
        p0.bind(genreList[p1], listener)
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val tvGenre = itemView.find<TextView>(R.id.tv_genre)
        fun bind(genre: GenreModel, listener: (GenreModel) -> Unit) {
            tvGenre.text = genre.title
            itemView.setOnClickListener {
                listener(genre)
            }
        }
    }

}