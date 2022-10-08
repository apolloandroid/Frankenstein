package com.example.itunesmvp.data.album.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import io.reactivex.rxjava3.core.Observable

@Dao
interface AlbumDao {
    @Query("SELECT * from albums")
    fun getAll(): Observable<List<AlbumEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(albums: List<AlbumEntity>)

    @Query("DELETE  FROM albums")
    fun clear()

    @Transaction
    fun clearAndInsertAll(albums: List<AlbumEntity>) {
        clear()
        insertAll(albums)
    }
}