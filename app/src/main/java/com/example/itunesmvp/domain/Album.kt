package com.example.itunesmvp.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Album(
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
    val coverUrl: String,
)
