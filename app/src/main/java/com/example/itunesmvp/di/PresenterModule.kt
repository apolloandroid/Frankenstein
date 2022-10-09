package com.example.itunesmvp.di

import com.example.itunesmvp.ui.MainPresenter
import com.example.itunesmvp.ui.albumdetails.AlbumDetailsPresenter
import com.example.itunesmvp.ui.searchalbum.SearchAlbumPresenter
import org.koin.dsl.module

val presenterModule = module {
    factory<MainPresenter> {
        MainPresenter(router = get())
    }
    factory<SearchAlbumPresenter> {
        SearchAlbumPresenter(albumRepository = get(), router = get())
    }
    factory<AlbumDetailsPresenter> { parameters ->
        AlbumDetailsPresenter(album = parameters[0], trackRepository = get())
    }
}