package com.example.starwarsstarships.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.starwarsstarships.R
import com.example.starwarsstarships.common.Constants
import com.example.starwarsstarships.databinding.FragmentStarshipDetailsBinding
import com.example.starwarsstarships.domain.model.Starship
import com.example.starwarsstarships.presentation.viewmodel.StarshipInfoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StarshipInfoFragment : Fragment(R.layout.fragment_starship_details) {

    private lateinit var mBinding: FragmentStarshipDetailsBinding
    private val viewModel: StarshipInfoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentStarshipDetailsBinding.inflate(layoutInflater)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getStarshipInfo().observe(viewLifecycleOwner, Observer {
            Log.d(Constants.TAG, it.name + " found!")
            setUI(it)
        })
    }

    override fun onResume() {
        super.onResume()
    }

    private fun setUI(it: Starship?) {
        if (it == null) {
            return
        }
        mBinding.tvName.text = it.name
        mBinding.tvCargoCapacity.text = it.cargoCapacity
        mBinding.tvConsumables.text = it.consumables
        mBinding.tvCostInCredits.text = it.costInCredits
        mBinding.tvCreated.text = it.created
        mBinding.tvCrew.text = it.crew
        mBinding.tvEdited.text = it.edited
        mBinding.tvHyperdriveRating.text = it.hyperdriveRating
        mBinding.tvLength.text = it.length
        mBinding.tvManufacturer.text = it.manufacturer
        mBinding.tvMaxAtmospheringSpeed.text = it.maxAtmospheringSpeed
        mBinding.tvMglt.text = it.mGLT
        mBinding.tvModel.text = it.model
        mBinding.tvPassengers.text = it.passengers
        mBinding.tvStarshipClass.text = it.starshipClass
    }

}