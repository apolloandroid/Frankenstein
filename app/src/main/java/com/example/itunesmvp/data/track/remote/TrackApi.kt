package com.example.itunesmvp.data.track.remote

import com.example.itunesmvp.data.track.remote.dto.GetTracksResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.POST
import retrofit2.http.Query

interface TrackApi {

    companion object {
        private val ENTITY_TYPE_SONG = "song"
    }

    @POST("lookup")
    fun getAlbumTracks(
        @Query("id") id: String,
        @Query("entity") entity: String = ENTITY_TYPE_SONG
    ): Observable<GetTracksResponse>
}