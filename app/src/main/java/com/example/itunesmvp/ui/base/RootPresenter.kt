package com.example.itunesmvp.ui.base

import com.example.itunesmvp.navigation.routers.ILocalRouter
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

/**
 * Base class for root Presenter for [RootFragment]
 */

abstract class RootPresenter(
    open val cicerone: Cicerone<Router>,
    open val localRouter: ILocalRouter
) : MvpPresenter<RootView>() {

    open fun onResume(navigator: Navigator) = cicerone.getNavigatorHolder().setNavigator(navigator)

    open fun onPause() = cicerone.getNavigatorHolder().removeNavigator()

    open fun setFirstScreen() = localRouter.setFirstScreen()
}