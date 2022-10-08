package com.example.itunesmvp.data.album.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.itunesmvp.data.AppDatabase
import com.example.itunesmvp.domain.Album

/**
 * !!! Do not just add new properties, but write Room migration !!!
 */
@Entity(tableName = AppDatabase.ALBUMS_TABLE_NAME)
data class AlbumEntity(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "collection_id")
    val collectionId: Int,
    @ColumnInfo(name = "artist_name")
    val artistName: String,
    @ColumnInfo(name = "track_count")
    val trackCount: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "cover_url")
    val coverUrl: String
) {

    companion object {
        fun mapFromDomain(album: Album): AlbumEntity = AlbumEntity(
            id = album.id,
            collectionId = album.collectionId,
            artistName = album.artistName,
            trackCount = album.trackCount,
            name = album.name,
            coverUrl = album.coverUrl
        )
    }

    fun mapToDomain(): Album = Album(
        id = id,
        collectionId = collectionId,
        artistName = artistName,
        trackCount = trackCount,
        name = name,
        coverUrl = coverUrl
    )
}