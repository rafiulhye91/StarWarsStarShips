package com.example.starwarsstarships.data.repository

import com.example.starwarsstarships.data.model.StarshipDTO
import com.example.starwarsstarships.data.model.StarshipsDTO
import com.example.starwarsstarships.data.remote.ApiServices
import com.example.starwarsstarships.domain.repository.StarshipsRepository

class StarshipsRepositoryImpl(private val mApiServices: ApiServices): StarshipsRepository {
    override suspend fun getStarships(): StarshipsDTO {
        return mApiServices.getStartships()
    }
}
