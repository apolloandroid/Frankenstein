package com.example.itunesmvp.data.album

import android.util.Log
import com.example.itunesmvp.data.album.local.AlbumDao
import com.example.itunesmvp.data.album.remote.AlbumRemoteDataSource
import com.example.itunesmvp.domain.Album
import io.reactivex.rxjava3.core.Observable

class AlbumRepository(
    private val remoteDataSource: AlbumRemoteDataSource,
    private val localDataSource: AlbumDao
) {

    fun getAllAlbumsFromLocal(): Observable<List<Album>> {
        return localDataSource.getAll().map { entities ->
            entities.map { entity -> entity.mapToDomain() }
        }
    }

    fun getAlbumsByKeyWordFromRemote(keyWord: String): Observable<List<Album>> {
        return remoteDataSource.getAlbumsByKeyWord(keyWord)
    }

    fun clear() {
        Log.d("TAG", "repository: clear")
        localDataSource.clear()
    }
}