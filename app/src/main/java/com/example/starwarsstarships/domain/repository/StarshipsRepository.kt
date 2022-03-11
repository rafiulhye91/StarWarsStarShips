package com.example.starwarsstarships.domain.repository

import com.example.starwarsstarships.data.model.StarshipDTO
import com.example.starwarsstarships.data.model.StarshipsDTO

interface StarshipsRepository{
    suspend fun getStarships(): StarshipsDTO
}
