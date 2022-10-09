package com.example.itunesmvp.navigation

import com.example.itunesmvp.ui.albumdetails.AlbumDetailsFragment
import com.example.itunesmvp.ui.searchalbum.SearchAlbumFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun searchAlbumFragment() = FragmentScreen { SearchAlbumFragment() }

    fun albumDetailsFragment() = FragmentScreen { AlbumDetailsFragment() }
}