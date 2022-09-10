package com.example.itunesmvp.di

import com.example.itunesmvp.data.album.remote.AlbumRemoteDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single<AlbumRemoteDataSource> {
        AlbumRemoteDataSource(api = get())
    }
}