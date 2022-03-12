package com.example.starwarsstarships.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwarsstarships.common.Constants.TAG
import com.example.starwarsstarships.databinding.ActivityMainBinding
import com.example.starwarsstarships.domain.model.Starship
import com.example.starwarsstarships.presentation.adapter.CustomAdapter
import com.example.starwarsstarships.presentation.state.StarshipsState
import com.example.starwarsstarships.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var  viewModel: MainViewModel
    private lateinit var mBinding: ActivityMainBinding
    private lateinit var mCustomAdapter: CustomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
        mCustomAdapter = CustomAdapter()
        setRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getStarships()
        val list:MutableList<Starship> = mutableListOf()
        viewModel.mStarshipsState.observe(
            this, Observer {
                if (it.isLoading){
                    Log.d(TAG, "loading...")
                    setLoadingUI()
                    return@Observer
                }
                if (it.starShips != null) {
                    it.starShips.forEach {
                        Log.d(TAG, it.name)
                        list.add(it)
                    }
                    Log.d(TAG,  "size of the list"+list.size.toString())
                    setDataUI(list)
                    return@Observer
                }
                if (!it.error!!.isEmpty()){
                    Log.d(TAG, it.error)
                    setErrorUI(it)
                }

            }
        )
    }

    private fun setDataUI(starships:List<Starship>) {
        mBinding.progressBar.visibility = View.GONE
        mBinding.recyclerViewStarships.visibility = View.VISIBLE
        mCustomAdapter.setData(starships)
        mCustomAdapter.notifyDataSetChanged()
    }

    private fun setRecyclerView() {
        //mCustomAdapter.setListener(this)
        mBinding.recyclerViewStarships.adapter = mCustomAdapter
        mBinding.recyclerViewStarships.layoutManager = LinearLayoutManager(this)
        mBinding.recyclerViewStarships
            .addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }

    private fun setLoadingUI(){
        mBinding.progressBar.visibility = View.VISIBLE
        mBinding.recyclerViewStarships.visibility = View.GONE
    }

    private fun setErrorUI(it: StarshipsState?) {
        mBinding.recyclerViewStarships.visibility = View.GONE
        mBinding.progressBar.visibility = View.GONE
        Toast.makeText(this, it!!.error, Toast.LENGTH_LONG).show()
    }
}
