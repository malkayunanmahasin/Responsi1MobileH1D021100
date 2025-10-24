package com.example.responsi1mobileh1d021100.data.network

import com.example.responsi1mobileh1d021100.utils.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val client = OkHttpClient.Builder()
        .addInterceptor { chain ->
            val request = chain.request().newBuilder()
                .addHeader("X-Auth-Token", "9982a8fe229344feba3b9ecc0d85bef4")
                .build()
            chain.proceed(request)
        }
        .build()

    val api: FootballDataApi by lazy {
        Retrofit.Builder()
            .baseUrl(Constants.API_URI)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FootballDataApi::class.java)
    }
}