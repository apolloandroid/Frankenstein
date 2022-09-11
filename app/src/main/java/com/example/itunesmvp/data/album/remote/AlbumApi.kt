package com.example.itunesmvp.data.album.remote

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumApi {

    companion object {
        private const val DEFAULT_COUNTRY_CODE = "us"
        private const val DEFAULT_CONTENT_TYPE = "music"
        private const val DEFAULT_ENTITY_TYPE = "album"
    }

    @GET("search")
    fun getAlbumsByName(
        @Query("term") term: String,
        @Query("country") country: String = DEFAULT_COUNTRY_CODE,
        @Query("media") contentType: String = DEFAULT_CONTENT_TYPE,
        @Query("entity") entityType: String = DEFAULT_ENTITY_TYPE
    ): Single<GetAlbumsResponse>
}