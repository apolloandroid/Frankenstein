package com.example.itunesmvp.data.track.remote.dto

import com.example.itunesmvp.domain.Track
import com.google.gson.annotations.SerializedName

data class TrackDto(
    @SerializedName("wrapperType")
    val type: String,
    @SerializedName("trackName")
    val name: String?,
    @SerializedName("trackNumber")
    val number: Int,
    @SerializedName("trackTimeMillis")
    val timeMillis: Int
) {

    companion object {
        fun mapFromDomain(track: Track): TrackDto = TrackDto(
            type = track.type,
            name = track.name,
            number = track.number,
            timeMillis = track.timeMillis
        )
    }

    fun mapToDomain(): Track = Track(
        type = type,
        name = name,
        number = number,
        timeMillis = timeMillis
    )
}
