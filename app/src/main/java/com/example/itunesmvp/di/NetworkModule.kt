package com.example.itunesmvp.di

import com.example.itunesmvp.data.album.remote.AlbumApi
import com.example.itunesmvp.data.track.remote.TrackApi
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    val baseUrl = "https://itunes.apple.com/"
    single<Gson> { GsonBuilder().create() }
    single<OkHttpClient> {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(60, TimeUnit.SECONDS).build()
    }
    single<Converter.Factory> { GsonConverterFactory.create(get()) }
    single<CallAdapter.Factory> { RxJava3CallAdapterFactory.create() }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(get())
            .addCallAdapterFactory(get())
            .client(get())
            .build()
    }
    single<AlbumApi> { get<Retrofit>().create(AlbumApi::class.java) }
    single<TrackApi> { get<Retrofit>().create(TrackApi::class.java) }
}