package com.azamora.listapp

import android.app.Application
import com.azamora.listapp.data.LaptopRepository
import com.azamora.listapp.data.LaptopRepositoryIml
import com.azamora.listapp.data.net.RetrofitClient
import com.azamora.listapp.viewmodel.LaptopViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

class App : Application() {

    companion object {
        lateinit var INSTANCE: App
    }

    init {
        INSTANCE = this
    }

    lateinit var cicerone: Cicerone<Router>

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        this.initCicerone()

        startKoin {
            androidContext(this@App)
            modules(myModule)
        }

    }

    private fun initCicerone() {
        this.cicerone = Cicerone.create()
    }

    val myModule = module {
        viewModel { LaptopViewModel(get()) }
        single<LaptopRepository> { LaptopRepositoryIml(get()) }
        single { RetrofitClient() }
    }
}