package com.example.starwarsstarships.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.starwarsstarships.common.Constants
import com.example.starwarsstarships.domain.model.Starship

class StarshipInfoViewModel : ViewModel() {
    private val _mStarshipInfo = MutableLiveData<Starship>()

    fun setStarshipInfo(starship: Starship) {
        Log.d(Constants.TAG, "setStarshipInfo: called!!")
        _mStarshipInfo.postValue(starship)
    }

    fun getStarshipInfo(): LiveData<Starship> {
        Log.d(Constants.TAG, "getStarshipInfo: called!!")
        return _mStarshipInfo
    }
}