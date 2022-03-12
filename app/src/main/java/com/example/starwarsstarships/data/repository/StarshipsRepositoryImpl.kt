package com.example.starwarsstarships.data.repository

import com.example.starwarsstarships.data.model.StarshipDTO
import com.example.starwarsstarships.data.model.StarshipsDTO
import com.example.starwarsstarships.data.remote.ApiServices
import com.example.starwarsstarships.domain.repository.StarshipsRepository
import javax.inject.Inject

class StarshipsRepositoryImpl @Inject constructor (private val mApiServices: ApiServices): StarshipsRepository {
    override suspend fun getStarships(): StarshipsDTO {
        return mApiServices.getStartships()
    }

    override suspend fun getStarshipsFromPage(page: Int): StarshipsDTO {
        return mApiServices.getStartshipsFromPage(page)
    }
}
