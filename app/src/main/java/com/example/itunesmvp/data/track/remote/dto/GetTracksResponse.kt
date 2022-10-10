package com.example.itunesmvp.data.track.remote.dto

import com.google.gson.annotations.SerializedName

data class GetTracksResponse(
    @SerializedName("results")
    val results: List<TrackDto>
)
