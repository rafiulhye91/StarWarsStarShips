package com.example.starwarsstarships.presentation.state

import com.example.starwarsstarships.domain.model.Starship

data class StarshipsState(
    val starShips:List<Starship> ?= emptyList(),
    val error: String ? = "",
    val isLoading: Boolean = false
) {
}