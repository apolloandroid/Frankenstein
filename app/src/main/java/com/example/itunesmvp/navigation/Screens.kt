package com.example.itunesmvp.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.itunesmvp.ui.albumdetails.AlbumDetailsFragment
import com.example.itunesmvp.ui.searchalbum.SearchAlbumFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object SearchAlbumScreen : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment = SearchAlbumFragment()
}

object AlbumDetailsScreen : FragmentScreen {

    override fun createFragment(factory: FragmentFactory): Fragment = AlbumDetailsFragment()
}