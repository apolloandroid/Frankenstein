package com.example.itunesmvp.di

import com.example.itunesmvp.data.album.AlbumRepository
import com.example.itunesmvp.data.track.TrackRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<AlbumRepository> {
        AlbumRepository(remoteDataSource = get(), localDataSource = get())
    }

    single<TrackRepository> {
        TrackRepository(remoteDataSource = get())
    }
}