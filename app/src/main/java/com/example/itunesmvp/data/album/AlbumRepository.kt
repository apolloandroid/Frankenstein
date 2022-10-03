package com.example.itunesmvp.data.album

import com.example.itunesmvp.data.album.remote.AlbumRemoteDataSource
import com.example.itunesmvp.domain.Album
import io.reactivex.rxjava3.core.Observable

class AlbumRepository(private val remoteDataSource: AlbumRemoteDataSource) {

    fun getAlbumsByKeyWord(keyWord: String): Observable<List<Album>> {
        return remoteDataSource.getAlbumsByKeyWord(keyWord)
    }
}