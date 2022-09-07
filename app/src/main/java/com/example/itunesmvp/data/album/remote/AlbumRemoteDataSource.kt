package com.example.itunesmvp.data.album.remote

import com.example.itunesmvp.domain.Album
import io.reactivex.rxjava3.core.Single

class AlbumRemoteDataSource(private val api: AlbumApi) {

    suspend fun getAlbumsByName(name: String): Single<List<Album>> = api.getAlbumsByName(name)
}