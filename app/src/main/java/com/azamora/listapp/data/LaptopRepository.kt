package com.azamora.listapp.data

import androidx.lifecycle.LiveData
import com.azamora.listapp.data.model.LaptopModel

interface LaptopRepository {
    fun getLaptopsList(): LiveData<List<LaptopModel>?>
}