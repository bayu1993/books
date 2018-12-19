package com.example.bayu.mamikostest.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.bayu.mamikostest.R
import com.example.bayu.mamikostest.R.id.*
import com.example.bayu.mamikostest.ui.buku.BukuFragment
import com.example.bayu.mamikostest.ui.home.HomeFragment
import com.example.bayu.mamikostest.ui.penulis.PenulisFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                menu_home -> {
                    supportActionBar?.title = resources.getString(R.string.home)
                    loadFragmentHome(savedInstanceState)
                }
                menu_book -> {
                    supportActionBar?.title = resources.getString(R.string.buku)
                    loadFragmentBuku(savedInstanceState)
                }
                menu_penulis -> {
                    supportActionBar?.title = resources.getString(R.string.penulis)
                    loadFragmentPenulis(savedInstanceState)
                }
            }
            true
        }
        navigation.selectedItemId = menu_home
    }

    private fun loadFragmentBuku(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_container,
                    BukuFragment(), BukuFragment::class.java.simpleName)
                .addToBackStack(null)
                .commit()
        }
    }

    private fun loadFragmentHome(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.frame_container,
                    HomeFragment(), HomeFragment::class.java.simpleName)
                .addToBackStack(null)
                .commit()
        }
    }

    private fun loadFragmentPenulis(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(
                    R.id.frame_container,
                    PenulisFragment(), PenulisFragment::class.java.simpleName)
                .addToBackStack(null)
                .commit()
        }
    }
}
