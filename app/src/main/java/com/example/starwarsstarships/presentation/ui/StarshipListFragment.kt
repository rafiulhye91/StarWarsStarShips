package com.example.starwarsstarships.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.starwarsstarships.R
import com.example.starwarsstarships.common.Constants
import com.example.starwarsstarships.databinding.FragmentStarshipListBinding
import com.example.starwarsstarships.domain.model.Starship
import com.example.starwarsstarships.presentation.adapter.CustomAdapter
import com.example.starwarsstarships.presentation.state.StarshipsState
import com.example.starwarsstarships.presentation.viewmodel.StarshipInfoViewModel
import com.example.starwarsstarships.presentation.viewmodel.StarshipListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StarshipListFragment : Fragment(R.layout.fragment_starship_list),
    CustomAdapter.OnItemClickListener {

    private lateinit var mBinding: FragmentStarshipListBinding
    private lateinit var starshipListViewModel: StarshipListViewModel
    private val starshipInfoViewModel: StarshipInfoViewModel by activityViewModels()
    private lateinit var mCustomAdapter: CustomAdapter
    private lateinit var fragment: StarshipInfoFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        starshipListViewModel = ViewModelProvider(this).get(StarshipListViewModel::class.java)
        mBinding = FragmentStarshipListBinding.inflate(layoutInflater)
        mCustomAdapter = CustomAdapter()
        setRecyclerView()
        return mBinding.root
    }

    override fun onResume() {
        super.onResume()
        starshipListViewModel.getStarships()
        val list: MutableList<Starship> = mutableListOf()
        starshipListViewModel.mStarshipsState.observe(
            this, Observer {
                if (it.isLoading) {
                    Log.d(Constants.TAG, "loading...")
                    setLoadingUI()
                    return@Observer
                }
                if (it.starShips != null) {
                    it.starShips.forEach {
                        Log.d(Constants.TAG, it.name)
                        list.add(it)
                    }
                    Log.d(Constants.TAG, "size of the list " + list.size.toString())
                    setDataUI(list)
                    return@Observer
                }
                if (!it.error!!.isEmpty()) {
                    Log.d(Constants.TAG, it.error)
                    setErrorUI(it)
                }

            }
        )
    }

    private fun setDataUI(starships: List<Starship>) {
        mBinding.progressBar.visibility = View.GONE
        mBinding.recyclerViewStarships.visibility = View.VISIBLE
        mCustomAdapter.setData(starships)
        mCustomAdapter.notifyDataSetChanged()
    }

    private fun setRecyclerView() {
        mCustomAdapter.setListener(this)
        mBinding.recyclerViewStarships.adapter = mCustomAdapter
        mBinding.recyclerViewStarships.layoutManager = LinearLayoutManager(context)
        mBinding.recyclerViewStarships
            .addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
    }

    private fun setLoadingUI() {
        mBinding.progressBar.visibility = View.VISIBLE
        mBinding.recyclerViewStarships.visibility = View.GONE
    }

    private fun setErrorUI(it: StarshipsState?) {
        mBinding.recyclerViewStarships.visibility = View.GONE
        mBinding.progressBar.visibility = View.GONE
        Toast.makeText(context, it!!.error, Toast.LENGTH_LONG).show()
    }

    override fun onItemClicked(starship: Starship) {
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        starshipInfoViewModel.setStarshipInfo(starship)
        fragment = StarshipInfoFragment()
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_view, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

}
