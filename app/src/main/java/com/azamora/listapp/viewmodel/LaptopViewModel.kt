package com.azamora.listapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.azamora.listapp.data.LaptopRepository
import com.azamora.listapp.data.LaptopRepositoryIml
import com.azamora.listapp.data.model.LaptopModel

class LaptopViewModel(private val repository: LaptopRepository = LaptopRepositoryIml()): ViewModel() {

    fun getLatopsList(): LiveData<List<LaptopModel>?> {
        return repository.getLaptopsList()
    }

}