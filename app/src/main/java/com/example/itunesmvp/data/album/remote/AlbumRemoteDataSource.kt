package com.example.itunesmvp.data.album.remote

import com.example.itunesmvp.domain.Album
import io.reactivex.rxjava3.core.Single

class AlbumRemoteDataSource(private val api: AlbumApi) {

    suspend fun getAlbums(name: String): Single<List<Album>> = api.getAlbums(name, "", "", "")
}