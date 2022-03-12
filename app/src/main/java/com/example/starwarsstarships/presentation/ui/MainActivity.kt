package com.example.starwarsstarships.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.starwarsstarships.R
import com.example.starwarsstarships.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var  viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.mStarshipsState.observe(
            this, Observer {
                if (it.isLoading){
                    Log.d("MainActivity", "loading...")
                }
                if (it.starShips != null) {
                    it.starShips.forEach {
                        Log.d("MainActivity", it.name)
                    }
                 }
                if (!it.error!!.isEmpty()){
                    Log.d("MainActivity", it.error)
                }

            }
        )
    }
}
