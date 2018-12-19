package com.example.bayu.mamikostest.ui.detail.genre

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.bayu.mamikostest.R
import com.example.bayu.mamikostest.data.model.BookGenreModel
import com.example.bayu.mamikostest.data.response.BookGenreResponse
import com.example.bayu.mamikostest.network.repo.BukuRepo
import com.example.bayu.mamikostest.ui.buku.BukuPresenter
import com.example.bayu.mamikostest.ui.buku.BukuView
import com.example.bayu.mamikostest.ui.detail.buku.DetailBukuActivity
import com.example.bayu.mamikostest.ui.home.HomeBookAdapter
import com.example.bayu.mamikostest.utils.ID_BUKU
import com.example.bayu.mamikostest.utils.ID_GENRE
import kotlinx.android.synthetic.main.fragment_buku.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class DetailGenreActivity : AppCompatActivity(), BukuView {
    private val dataBooks: MutableList<BookGenreModel> = mutableListOf()
    private lateinit var presenter: BukuPresenter
    private lateinit var adapter: HomeBookAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_buku)

        getBooks()
    }

    private fun getBooks() {
        val id = intent.getIntExtra(ID_GENRE, 0)
        presenter = BukuPresenter(this, BukuRepo())
        presenter.getBookByGenre(id)

        rv_books.layoutManager = LinearLayoutManager(this)
        adapter = HomeBookAdapter(dataBooks) {
            startActivity<DetailBukuActivity>(ID_BUKU to id)
        }
        rv_books.adapter = adapter
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
