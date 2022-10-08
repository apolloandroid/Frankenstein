package com.example.itunesmvp.data.album

import com.example.itunesmvp.data.album.local.AlbumDao
import com.example.itunesmvp.data.album.local.AlbumEntity
import com.example.itunesmvp.data.album.remote.AlbumRemoteDataSource
import com.example.itunesmvp.domain.Album
import io.reactivex.rxjava3.core.Observable

class AlbumRepository(
    private val remoteDataSource: AlbumRemoteDataSource,
    private val localDataSource: AlbumDao
) {

    fun getAlbumsByKeyWord(keyWord: String): Observable<List<Album>> {
        return remoteDataSource.getAlbumsByKeyWord(keyWord).flatMap { albums ->
            val albumEntities = albums.map { album -> AlbumEntity.mapFromDomain(album) }
            localDataSource.clearAndInsertAll(albumEntities)
            localDataSource.getAll().map { entities ->
                entities.map { it.mapToDomain() }
            }
        }
    }
}