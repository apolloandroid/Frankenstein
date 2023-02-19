package com.example.itunesmvp.navigation.routers

import com.example.itunesmvp.domain.Album
import com.example.itunesmvp.navigation.Screens
import com.github.terrakok.cicerone.Router

class SearchAlbumRouter(private val router: Router) : ILocalRouter {

    override fun setFirstScreen() = router.newRootScreen(Screens.SearchAlbumScreen())

    override fun routeBack() = router.exit()

    fun routeToAlbumDetails(album: Album) = router.navigateTo(Screens.AlbumDetailsScreen(album))
}