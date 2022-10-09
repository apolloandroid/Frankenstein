package com.example.itunesmvp.ui

import com.example.itunesmvp.navigation.Screens
import com.github.terrakok.cicerone.Router
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class MainPresenter(private val router: Router) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(Screens.searchAlbumFragment())
    }
}