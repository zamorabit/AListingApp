package com.azamora.listapp.data.net

import com.azamora.listapp.data.model.LaptopModel
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val moviesApi: LaptopApi

    companion object {
        private const val TMDB_BASE_URL = "http://private-f0eea-mobilegllatam.apiary-mock.com/"
    }

    init {
        val builder = OkHttpClient.Builder()
        val okHttpClient = builder.build()
        val retrofit = Retrofit.Builder()
            .baseUrl(TMDB_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
        moviesApi = retrofit.create(LaptopApi::class.java)
    }

    fun getLaptopsList(): Call<List<LaptopModel>> {
        return moviesApi.getLaptopsList()
    }

}