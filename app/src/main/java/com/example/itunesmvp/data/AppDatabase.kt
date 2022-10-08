package com.example.itunesmvp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.itunesmvp.data.album.local.AlbumEntity
import com.example.itunesmvp.data.album.local.AlbumDao

@Database(
    entities = [AlbumEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "itunes_search_database"
        const val ALBUMS_TABLE_NAME = "albums"
    }

    abstract fun albumDao(): AlbumDao
}