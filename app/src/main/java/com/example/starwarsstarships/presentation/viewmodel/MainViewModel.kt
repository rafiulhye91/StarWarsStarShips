package com.example.starwarsstarships.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.starwarsstarships.common.Resource
import com.example.starwarsstarships.domain.usecase.GetStarshipsUsecase
import com.example.starwarsstarships.presentation.state.StarshipsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getStarshipsUsecase: GetStarshipsUsecase):ViewModel() {

    private val _mStarshipsState: MutableLiveData<StarshipsState>  = MutableLiveData<StarshipsState>()
    val mStarshipsState:LiveData<StarshipsState> = _mStarshipsState

    init {
        getStarships()
    }

    private fun getStarships(){
        getStarshipsUsecase().onEach {
            if(it is Resource.Loading){
                _mStarshipsState.value = StarshipsState(isLoading = true)
            }
            if(it is Resource.Success){
                _mStarshipsState.value = StarshipsState(starShips = it.data, isLoading = false)
            }
            if(it is Resource.Error){
                _mStarshipsState.value = StarshipsState(error = it.errMessage,isLoading = false)
            }
        }.launchIn(viewModelScope)
    }
}
