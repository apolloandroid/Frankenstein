package com.example.itunesmvp.data.album.remote

import com.example.itunesmvp.data.album.remote.dto.AlbumDto
import com.google.gson.annotations.SerializedName

data class GetAlbumsResponse(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val results: List<AlbumDto>
)
