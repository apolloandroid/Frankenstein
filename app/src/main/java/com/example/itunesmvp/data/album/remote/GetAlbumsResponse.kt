package com.example.itunesmvp.data.album.remote

import com.example.itunesmvp.domain.Album
import com.google.gson.annotations.SerializedName

data class GetAlbumsResponse(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val results: List<Album>
)
