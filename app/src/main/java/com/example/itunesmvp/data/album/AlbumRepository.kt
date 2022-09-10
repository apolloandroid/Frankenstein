package com.example.itunesmvp.data.album

import com.example.itunesmvp.data.album.remote.AlbumRemoteDataSource
import com.example.itunesmvp.domain.Album
import io.reactivex.rxjava3.core.Single

class AlbumRepository(private val remoteDataSource: AlbumRemoteDataSource) {

    fun getAlbumsByName(name: String): Single<List<Album>> {
//        remoteDataSource.getAlbumsByName(name)
        val albums = listOf(
            Album(
                id = 1,
                collectionId = 2,
                artistName = "Bulanova",
                trackCount = 1,
                name = "Best Hits",
                coverUrl = "url",
            ),
            Album(
                id = 1,
                collectionId = 2,
                artistName = "Bulanve",
                trackCount = 1,
                name = "Best Hits",
                coverUrl = "url",
            ),
            Album(
                id = 1,
                collectionId = 2,
                artistName = "Bulnove",
                trackCount = 1,
                name = "Best Hits",
                coverUrl = "url",
            ),
            Album(
                id = 1,
                collectionId = 2,
                artistName = "Buanove",
                trackCount = 1,
                name = "Best Hits",
                coverUrl = "url",
            )
        )
        return Single.create { subscriber ->
            subscriber.onSuccess(albums.filter { it.artistName == name })
        }
    }
}