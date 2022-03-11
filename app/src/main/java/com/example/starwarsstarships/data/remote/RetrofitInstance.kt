package com.example.starwarsstarships.data.remote

import com.example.starwarsstarships.data.remote.Constants.BASE_URL
import com.example.starwarsstarships.data.remote.Constants.TIMEOUT
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import retrofit2.Retrofit

object RetrofitInstance {

    fun getApiServices():ApiServices{

        val  httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .callTimeout(TIMEOUT,TimeUnit.SECONDS)
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()
            .create(ApiServices::class.java)
    }

}