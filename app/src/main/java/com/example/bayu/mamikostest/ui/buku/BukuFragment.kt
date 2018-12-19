package com.example.bayu.mamikostest.ui.buku

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bayu.mamikostest.R
import com.example.bayu.mamikostest.data.model.BookGenreModel
import com.example.bayu.mamikostest.data.response.BookGenreResponse
import com.example.bayu.mamikostest.network.repo.BukuRepo
import com.example.bayu.mamikostest.ui.detail.buku.DetailBukuActivity
import com.example.bayu.mamikostest.ui.home.HomeBookAdapter
import com.example.bayu.mamikostest.utils.ID_BUKU
import com.example.bayu.mamikostest.utils.compositeDisposable
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast

class BukuFragment : Fragment(),BukuView {

    private val dataBooks:MutableList<BookGenreModel> = mutableListOf()
    private lateinit var presenter: BukuPresenter
    private lateinit var adapter:HomeBookAdapter
    private lateinit var rvBooks:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_buku, container, false)
        rvBooks = view.find(R.id.rv_books)
        rvBooks.layoutManager = LinearLayoutManager(activity)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = BukuPresenter(this, BukuRepo(compositeDisposable))
        presenter.getBooks()
        adapter = HomeBookAdapter(dataBooks){
            startActivity<DetailBukuActivity>(ID_BUKU to it.id)
        }
        rvBooks.adapter = adapter
    }

    override fun showBook(data: BookGenreResponse) {
        dataBooks.clear()
        dataBooks.addAll(data.result)
        adapter.notifyDataSetChanged()
    }

    override fun onError(error: Throwable) {
        toast(error.localizedMessage).show()
    }
}
