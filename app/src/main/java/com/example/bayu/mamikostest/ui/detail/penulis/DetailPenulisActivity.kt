package com.example.bayu.mamikostest.ui.detail.penulis

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.bayu.mamikostest.BuildConfig
import com.example.bayu.mamikostest.R
import com.example.bayu.mamikostest.data.response.PenulisDetailResponse
import com.example.bayu.mamikostest.network.repo.PenulisRepo
import com.example.bayu.mamikostest.utils.ID_PENULIS
import com.example.bayu.mamikostest.utils.loadImage
import kotlinx.android.synthetic.main.activity_detail_penulis.*
import org.jetbrains.anko.toast

class DetailPenulisActivity : AppCompatActivity(),PenulisDetailView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_penulis)

        getDetail()
    }

    private fun getDetail() {
        val id = intent.getIntExtra(ID_PENULIS, 0)
        val presenter = PenulisPresenterDetail(this, PenulisRepo())
        presenter.getPenulisDetail(id)
    }

    override fun showPenulis(data: PenulisDetailResponse) {
        supportActionBar?.title = data.result.username
        img_cover_detail.loadImage("${BuildConfig.BASE_URL}${data.result.photoUrl}")
        tv_name_detail.text = data.result.name
        tv_email.text = data.result.email
        tv_telp.text = data.result.phone
    }

    override fun onError(error: Throwable) {
        toast(error.localizedMessage).show()
    }
}
