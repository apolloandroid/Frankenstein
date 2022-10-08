package com.example.itunesmvp.di

import androidx.room.Room
import com.example.itunesmvp.data.AppDatabase
import com.example.itunesmvp.data.album.local.AlbumDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<AppDatabase> {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, AppDatabase.DATABASE_NAME)
            .build()
    }
    single<AlbumDao> { get<AppDatabase>().albumDao() }
}