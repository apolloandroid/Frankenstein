package com.example.itunesmvp

import android.app.Application
import com.example.itunesmvp.di.navigationModule
import com.example.itunesmvp.di.networkModule
import com.example.itunesmvp.di.presenterModule
import com.example.itunesmvp.di.remoteDataSourceModule
import com.example.itunesmvp.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ItunesApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ItunesApplication)
            modules(
                listOf(
                    presenterModule,
                    repositoryModule,
                    remoteDataSourceModule,
                    networkModule,
                    navigationModule
                )
            )
        }
    }
}