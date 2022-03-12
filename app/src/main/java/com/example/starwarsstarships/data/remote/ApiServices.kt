package com.example.starwarsstarships.data.remote

import com.example.starwarsstarships.data.model.StarshipsDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("starships/")
    suspend fun getStarships(): StarshipsDTO

    @GET("starships/")
    suspend fun getStarshipsFromPage(@Query("page") currentPage: Int): StarshipsDTO
}
