package com.example.bayu.mamikostest.ui.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bayu.mamikostest.R
import com.example.bayu.mamikostest.data.model.BookGenreModel
import com.example.bayu.mamikostest.data.model.GenreModel
import com.example.bayu.mamikostest.data.response.BookGenreResponse
import com.example.bayu.mamikostest.data.response.GenreResponse
import com.example.bayu.mamikostest.network.repo.MainRepo
import com.example.bayu.mamikostest.ui.detail.buku.DetailBukuActivity
import com.example.bayu.mamikostest.ui.detail.genre.DetailGenreActivity
import com.example.bayu.mamikostest.utils.ID_BUKU
import com.example.bayu.mamikostest.utils.ID_GENRE
import com.google.gson.Gson
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast


class HomeFragment : Fragment(), MainView {
    private val dataGenre: MutableList<GenreModel> = mutableListOf()
    private val dataBook: MutableList<BookGenreModel> = mutableListOf()

    private lateinit var presenter: MainPresenter
    private lateinit var rvGenre: RecyclerView
    private lateinit var rvNewBook: RecyclerView
    private lateinit var adapterBook: HomeBookAdapter
    private lateinit var adapterGenre: HomeGenreAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        rvGenre = view.find(R.id.rv_genre)
        rvNewBook = view.find(R.id.rv_new)

        rvGenre.layoutManager = GridLayoutManager(activity, 3)
        rvNewBook.layoutManager = LinearLayoutManager(activity)
        return view
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = MainPresenter(this, MainRepo())
        presenter.getGenre()
        presenter.getNewBook()

        adapterBook = HomeBookAdapter(dataBook) {
            startActivity<DetailBukuActivity>(ID_BUKU to it.id)
        }
        adapterGenre = HomeGenreAdapter(dataGenre) {
            startActivity<DetailGenreActivity>(ID_GENRE to it.id)
        }
        rvNewBook.adapter = adapterBook
        rvGenre.adapter = adapterGenre
    }

    override fun showNew(data: BookGenreResponse) {
        dataBook.clear()
        dataBook.addAll(data.result)
        adapterBook.notifyDataSetChanged()
    }

    override fun showGenre(data: GenreResponse) {
        dataGenre.clear()
        dataGenre.addAll(data.resource)
        adapterGenre.notifyDataSetChanged()
    }

    override fun onError(error: Throwable) {
        toast(error.localizedMessage).show()
    }


}
