package com.example.itunesmvp.domain

import java.util.UUID


data class Album(
    val id: String = UUID.randomUUID().toString(),
    val collectionId: Int,
    val artistName: String,
    val trackCount: Int,
    val name: String,
    val coverUrl: String
)
