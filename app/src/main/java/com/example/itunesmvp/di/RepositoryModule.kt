package com.example.itunesmvp.di

import com.example.itunesmvp.data.album.AlbumRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<AlbumRepository> {
        AlbumRepository(remoteDataSource = get())
    }
}