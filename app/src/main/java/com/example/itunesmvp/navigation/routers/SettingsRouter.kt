package com.example.itunesmvp.navigation.routers

import com.example.itunesmvp.navigation.Screens
import com.github.terrakok.cicerone.Router

class SettingsRouter(private val router: Router) : ILocalRouter {

    override fun setFirstScreen() = router.newRootScreen(Screens.SettingsScreen())

    override fun routeBack() = router.exit()
}