package com.example.itunesmvp.di

import com.example.itunesmvp.ui.searchalbum.SearchAlbumPresenter
import org.koin.dsl.module

val presenterModule = module {
    factory<SearchAlbumPresenter> {
        SearchAlbumPresenter(get())
    }
}