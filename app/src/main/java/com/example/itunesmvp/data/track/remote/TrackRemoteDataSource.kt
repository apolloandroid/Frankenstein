package com.example.itunesmvp.data.track.remote

import com.example.itunesmvp.domain.Track
import io.reactivex.rxjava3.core.Observable

class TrackRemoteDataSource(private val api: TrackApi) {

    fun getTracksByAlbum(albumId: Int): Observable<List<Track>> {
        return api.getAlbumTracks(albumId.toString()).map { response ->
            response.results.map { dto -> dto.mapToDomain() }
        }
    }
}