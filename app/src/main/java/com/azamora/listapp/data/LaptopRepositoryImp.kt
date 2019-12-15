package com.azamora.listapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.azamora.listapp.data.model.LaptopModel
import com.azamora.listapp.data.net.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LaptopRepositoryIml: LaptopRepository {

    private val retrofitClient = RetrofitClient()

    override fun getLaptopsList(): LiveData<List<LaptopModel>?> {
        val data = MutableLiveData<List<LaptopModel>?>()

        retrofitClient.getLaptopsList().enqueue(object : Callback<List<LaptopModel>?> {

            override fun onFailure(call: Call<List<LaptopModel>?>, t: Throwable) {
                data.value = null
                Log.d(this.javaClass.simpleName, "Failure")
            }

            override fun onResponse(call: Call<List<LaptopModel>?>, response: Response<List<LaptopModel>?>) {
                data.value = response.body()
            }
        })
        return data
    }
}