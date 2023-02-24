package com.example.itunesmvp.di

import com.example.itunesmvp.navigation.LocalCiceroneHolder
import com.example.itunesmvp.navigation.NavigationTabTags
import com.example.itunesmvp.navigation.routers.FavoriteAlbumsRouter
import com.example.itunesmvp.navigation.routers.ILocalRouter
import com.example.itunesmvp.navigation.routers.SearchAlbumRouter
import com.example.itunesmvp.navigation.routers.SettingsRouter
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import org.koin.dsl.module

val navigationModule = module {
    single<Cicerone<Router>>(searchAlbumQualifier) {
        LocalCiceroneHolder.getCicerone(NavigationTabTags.TAG_SEARCH_ALBUM)
    }

    single<Cicerone<Router>>(favoriteAlbumsQualifier) {
        LocalCiceroneHolder.getCicerone(NavigationTabTags.TAG_FAVORITE_ALBUMS)
    }

    single<Cicerone<Router>>(settingsQualifier) {
        LocalCiceroneHolder.getCicerone(NavigationTabTags.TAG_SETTINGS)
    }

    single<Router>(searchAlbumQualifier) {
        get<Cicerone<Router>>(searchAlbumQualifier).router
    }

    single<Router>(favoriteAlbumsQualifier) {
        get<Cicerone<Router>>(favoriteAlbumsQualifier).router
    }

    single<Router>(settingsQualifier) {
        get<Cicerone<Router>>(settingsQualifier).router
    }

    single<ILocalRouter>(searchAlbumQualifier) {
        get<SearchAlbumRouter>()
    }

    single<ILocalRouter>(favoriteAlbumsQualifier) {
        get<FavoriteAlbumsRouter>()
    }

    single<ILocalRouter>(settingsQualifier) {
        get<SettingsRouter>()
    }

    single<SearchAlbumRouter>() {
        SearchAlbumRouter(router = get(searchAlbumQualifier))
    }

    single<FavoriteAlbumsRouter>() {
        FavoriteAlbumsRouter(router = get(favoriteAlbumsQualifier))
    }

    single<SettingsRouter>() {
        SettingsRouter(router = get(settingsQualifier))
    }
}