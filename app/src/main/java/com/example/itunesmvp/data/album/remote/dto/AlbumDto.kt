package com.example.itunesmvp.data.album.remote.dto

import com.example.itunesmvp.domain.Album
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AlbumDto(
    @Expose
    val id: Int,
    @SerializedName("collectionId")
    val collectionId: Int,
    @SerializedName("artistName")
    val artistName: String,
    @SerializedName("trackCount")
    val trackCount: Int,
    @SerializedName("collectionName")
    val name: String,
    @SerializedName("artworkUrl100")
    val coverUrl: String
) {

    fun mapToDomain(): Album = Album(
        id = id,
        collectionId = collectionId,
        artistName = artistName,
        trackCount = trackCount,
        name = name,
        coverUrl = coverUrl
    )
}