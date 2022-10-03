package com.example.itunesmvp.data.album.remote

import com.example.itunesmvp.domain.Album
import io.reactivex.rxjava3.core.Observable

class AlbumRemoteDataSource(private val api: AlbumApi) {

    fun getAlbumsByKeyWord(keyWord: String): Observable<List<Album>> {
        return api.getAlbumsByKeyWord(keyWord).map { response ->
            response.results.map { dto -> dto.mapToDomain() }
        }
    }
}