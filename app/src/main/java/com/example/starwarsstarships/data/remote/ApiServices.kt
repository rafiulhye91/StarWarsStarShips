package com.example.starwarsstarships.data.remote

import com.example.starwarsstarships.data.model.StarshipsDTO
import retrofit2.http.GET

interface ApiServices {
    @GET("starships/")
    suspend fun getStartships():StarshipsDTO
}