package com.example.itunesmvp.di

import com.example.itunesmvp.data.album.remote.AlbumRemoteDataSource
import com.example.itunesmvp.data.track.remote.TrackRemoteDataSource
import org.koin.dsl.module

val remoteDataSourceModule = module {
    single<AlbumRemoteDataSource> {
        AlbumRemoteDataSource(api = get())
    }
    single<TrackRemoteDataSource> {
        TrackRemoteDataSource(api = get())
    }
}