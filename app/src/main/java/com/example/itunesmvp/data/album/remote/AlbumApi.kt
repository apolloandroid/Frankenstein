package com.example.itunesmvp.data.album.remote

import com.example.itunesmvp.domain.Album
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumApi {

    @GET("search")
    fun getAlbums(
        @Query("term") term: String,
        @Query("country") country: String,
        @Query("media") type: String,
        @Query("entity") entityType: String
    ): Single<List<Album>>
}