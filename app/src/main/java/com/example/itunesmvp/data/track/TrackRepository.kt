package com.example.itunesmvp.data.track

import com.example.itunesmvp.data.track.remote.TrackRemoteDataSource
import com.example.itunesmvp.domain.Track

class TrackRepository(private val remoteDataSource: TrackRemoteDataSource) {

    fun getTracks(): List<Track> = listOf()
}