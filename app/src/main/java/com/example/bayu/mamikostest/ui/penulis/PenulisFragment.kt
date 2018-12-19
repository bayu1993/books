package com.example.bayu.mamikostest.ui.penulis


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bayu.mamikostest.R
import com.example.bayu.mamikostest.data.model.PenulisPopular
import com.example.bayu.mamikostest.data.response.PenulisPopularResponse
import com.example.bayu.mamikostest.network.repo.PenulisRepo
import com.example.bayu.mamikostest.ui.detail.penulis.DetailPenulisActivity
import com.example.bayu.mamikostest.utils.ID_PENULIS
import com.example.bayu.mamikostest.utils.compositeDisposable
import org.jetbrains.anko.find
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast

class PenulisFragment : Fragment(),PenulisView {
    private val penulis:MutableList<PenulisPopular> = mutableListOf()

    private lateinit var presenter: PenulisPresenter
    private lateinit var adapter: PenulisAdapter
    private lateinit var rvPenulis:RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =inflater.inflate(R.layout.fragment_penulis, container, false)
        rvPenulis = view.find(R.id.rv_penulis)
        rvPenulis.layoutManager = LinearLayoutManager(activity)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter = PenulisPresenter(this, PenulisRepo(compositeDisposable))
        presenter.getPenulis()
        adapter = PenulisAdapter(penulis){
            startActivity<DetailPenulisActivity>(ID_PENULIS to it.id)
        }
        rvPenulis.adapter = adapter
    }

    override fun showPenulis(data: PenulisPopularResponse) {
        penulis.clear()
        penulis.addAll(data.result)
        adapter.notifyDataSetChanged()
    }

    override fun onError(error: Throwable) {
        toast(error.localizedMessage).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

}
