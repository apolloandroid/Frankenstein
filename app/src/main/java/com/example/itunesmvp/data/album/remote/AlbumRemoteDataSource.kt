package com.example.itunesmvp.data.album.remote

import com.example.itunesmvp.domain.Album
import io.reactivex.rxjava3.core.Single

class AlbumRemoteDataSource(private val api: AlbumApi) {

    fun getAlbumsByName(name: String): Single<List<Album>> {
        return api.getAlbumsByName(name).map { response ->
            response.results.map { dto -> dto.mapToDomain() }
        }
    }
}