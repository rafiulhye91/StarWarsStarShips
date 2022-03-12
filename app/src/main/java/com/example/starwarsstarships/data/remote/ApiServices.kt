package com.example.starwarsstarships.data.remote

import com.example.starwarsstarships.data.model.StarshipsDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {
    @GET("starships/")
    suspend fun getStartships():StarshipsDTO
    @GET("starships/")
    suspend fun getStartshipsFromPage(@Query("page") currentPage:Int):StarshipsDTO
}
