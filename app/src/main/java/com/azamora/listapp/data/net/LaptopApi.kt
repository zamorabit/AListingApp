package com.azamora.listapp.data.net

import com.azamora.listapp.data.model.LaptopModel
import retrofit2.Call
import retrofit2.http.GET

interface LaptopApi {

    @GET("list")
    fun getLaptopsList(): Call<List<LaptopModel>>
}