package com.example.itunesmvp.domain


data class Album(
    val id: Int,
    val collectionId: Int,
    val artistName: String,
    val trackCount: Int,
    val name: String,
    val coverUrl: String
)
