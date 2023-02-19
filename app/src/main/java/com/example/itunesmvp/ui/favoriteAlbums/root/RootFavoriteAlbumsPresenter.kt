package com.example.itunesmvp.ui.favoriteAlbums.root

import com.example.itunesmvp.navigation.routers.ILocalRouter
import com.example.itunesmvp.ui.base.RootPresenter
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import moxy.InjectViewState

@InjectViewState
class RootFavoriteAlbumsPresenter(
    override val cicerone: Cicerone<Router>,
    override val localRouter: ILocalRouter
) : RootPresenter(cicerone, localRouter)