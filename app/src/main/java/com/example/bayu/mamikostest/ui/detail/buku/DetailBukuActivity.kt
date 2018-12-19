package com.example.bayu.mamikostest.ui.detail.buku

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.bayu.mamikostest.BuildConfig
import com.example.bayu.mamikostest.R
import com.example.bayu.mamikostest.data.response.BookDetailResponse
import com.example.bayu.mamikostest.network.repo.BukuRepo
import com.example.bayu.mamikostest.utils.ID_BUKU
import com.example.bayu.mamikostest.utils.compositeDisposable
import com.example.bayu.mamikostest.utils.loadImage
import kotlinx.android.synthetic.main.activity_detail_penulis.*
import org.jetbrains.anko.toast

class DetailBukuActivity : AppCompatActivity(),BukuDetailView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_penulis)

        val id = intent.getIntExtra(ID_BUKU,0)
        val presenter = DetailBukuPresenter(this, BukuRepo(compositeDisposable))
        presenter.getDetailBook(id)
    }

    override fun showBuku(data: BookDetailResponse) {
        supportActionBar?.title = data.result.title
        img_cover_detail.loadImage("${BuildConfig.BASE_URL}${data.result.cover_url}")
        tv_name_detail.text = data.result.title
        tv_email.text = data.result.desc
    }

    override fun onError(error: Throwable) {
        toast(error.localizedMessage).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}
