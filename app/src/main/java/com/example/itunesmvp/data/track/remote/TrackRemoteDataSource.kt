package com.example.itunesmvp.data.track.remote

import com.example.itunesmvp.data.track.remote.dto.TrackDto
import com.example.itunesmvp.domain.Track
import io.reactivex.rxjava3.core.Observable

class TrackRemoteDataSource(private val api: TrackApi) {

    fun getAlbumTracks(albumId: Int): Observable<List<Track>> {
        return api.getAlbumTracks(albumId.toString()).map { response ->
            response.results
                .filter { track -> track.type == TrackDto.TRACK_WRAPPER_TYPE }
                .map { dto -> dto.mapToDomain() }
        }
    }
}