package com.example.itunesmvp.navigation.routers

import com.example.itunesmvp.navigation.Screens
import com.github.terrakok.cicerone.Router

class FavoriteAlbumsRouter(private val router: Router) : ILocalRouter {

    override fun setFirstScreen() = router.newRootScreen(Screens.FavoriteAlbumsScreen())

    override fun routeBack() = router.exit()
}