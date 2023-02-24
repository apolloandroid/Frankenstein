package com.example.itunesmvp.di

import com.example.itunesmvp.ui.albumdetails.AlbumDetailsPresenter
import com.example.itunesmvp.ui.favoriteAlbums.root.RootFavoriteAlbumsPresenter
import com.example.itunesmvp.ui.searchalbum.SearchAlbumPresenter
import com.example.itunesmvp.ui.searchalbum.root.RootSearchAlbumPresenter
import com.example.itunesmvp.ui.settings.root.RootSettingsPresenter
import org.koin.dsl.module

val presenterModule = module {
    factory<RootSearchAlbumPresenter> {
        RootSearchAlbumPresenter(
            cicerone = get(searchAlbumQualifier),
            localRouter = get(searchAlbumQualifier)
        )
    }

    factory<RootFavoriteAlbumsPresenter> {
        RootFavoriteAlbumsPresenter(
            cicerone = get(favoriteAlbumsQualifier),
            localRouter = get(favoriteAlbumsQualifier)
        )
    }

    factory<RootSettingsPresenter> {
        RootSettingsPresenter(
            cicerone = get(settingsQualifier),
            localRouter = get(settingsQualifier)
        )
    }

    factory<SearchAlbumPresenter> {
        SearchAlbumPresenter(
            router = get(),
            albumRepository = get()
        )
    }

    factory<AlbumDetailsPresenter> { parameters ->
        AlbumDetailsPresenter(album = parameters[0], trackRepository = get())
    }
}