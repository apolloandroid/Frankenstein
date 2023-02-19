package com.example.itunesmvp.di

import com.example.itunesmvp.navigation.LocalCiceroneHolder
import com.example.itunesmvp.navigation.NavigationTabTags
import com.example.itunesmvp.navigation.routers.FavoriteAlbumsRouter
import com.example.itunesmvp.navigation.routers.ILocalRouter
import com.example.itunesmvp.navigation.routers.SearchAlbumRouter
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

    single<Router>(searchAlbumQualifier) {
        get<Cicerone<Router>>(searchAlbumQualifier).router
    }

    single<Router>(favoriteAlbumsQualifier) {
        get<Cicerone<Router>>(favoriteAlbumsQualifier).router
    }

    single<ILocalRouter>(searchAlbumQualifier) {
        get<SearchAlbumRouter>()
    }

    single<ILocalRouter>(favoriteAlbumsQualifier) {
        get<FavoriteAlbumsRouter>()
    }

    single<SearchAlbumRouter>() {
        SearchAlbumRouter(router = get(searchAlbumQualifier))
    }

    single<FavoriteAlbumsRouter>() {
        FavoriteAlbumsRouter(router = get(favoriteAlbumsQualifier))
    }
}