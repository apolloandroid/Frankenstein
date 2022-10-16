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
        const val TRACK_WRAPPER_TYPE = "track"
        private const val DEFAULT_NAME = "Unknown"

        fun mapFromDomain(track: Track): TrackDto = TrackDto(
            type = TRACK_WRAPPER_TYPE,
            name = track.name,
            number = track.number,
            timeMillis = track.timeMillis
        )
    }

    fun mapToDomain(): Track = Track(
        name = name ?: DEFAULT_NAME,
        number = number,
        timeMillis = timeMillis
    )
}
