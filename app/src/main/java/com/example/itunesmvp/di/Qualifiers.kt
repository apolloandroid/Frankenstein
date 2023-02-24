package com.example.itunesmvp.di

import org.koin.core.qualifier.named

/**
 * Each [Qualifier] corresponds to separate navigation tab
 */
val searchAlbumQualifier = named("search_album_qualifier")
val favoriteAlbumsQualifier = named("favorite_albums_qualifier")
val settingsQualifier = named("settings_qualifier")