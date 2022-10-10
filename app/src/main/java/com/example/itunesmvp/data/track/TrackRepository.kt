package com.example.itunesmvp.data.track

import com.example.itunesmvp.data.track.remote.TrackRemoteDataSource
import com.example.itunesmvp.domain.Track
import io.reactivex.rxjava3.core.Observable

class TrackRepository(private val remoteDataSource: TrackRemoteDataSource) {

    fun getTracks(albumId: Int): Observable<List<Track>> {
        return remoteDataSource.getTracksByAlbum(albumId)
    }
}