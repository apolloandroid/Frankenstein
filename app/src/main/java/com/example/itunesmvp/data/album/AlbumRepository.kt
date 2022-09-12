package com.example.itunesmvp.data.album

import com.example.itunesmvp.data.album.remote.AlbumRemoteDataSource
import com.example.itunesmvp.domain.Album
import io.reactivex.rxjava3.core.Single

class AlbumRepository(private val remoteDataSource: AlbumRemoteDataSource) {

    fun getAlbumsByName(name: String): Single<List<Album>> = remoteDataSource.getAlbumsByName(name)
}