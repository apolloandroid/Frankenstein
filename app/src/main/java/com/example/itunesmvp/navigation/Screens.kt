package com.example.itunesmvp.navigation

import com.example.itunesmvp.domain.Album
import com.example.itunesmvp.ui.albumdetails.AlbumDetailsFragment
import com.example.itunesmvp.ui.favoriteAlbums.FavoriteAlbumsFragment
import com.example.itunesmvp.ui.favoriteAlbums.root.RootFavoriteAlbumsFragment
import com.example.itunesmvp.ui.searchalbum.SearchAlbumFragment
import com.example.itunesmvp.ui.searchalbum.root.RootSearchAlbumFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun RootScreen(tabTag: String) = FragmentScreen {
        when (tabTag) {
            NavigationTabTags.TAG_SEARCH_ALBUM -> RootSearchAlbumFragment()
            else -> RootFavoriteAlbumsFragment()
        }
    }

    fun SearchAlbumScreen() = FragmentScreen { SearchAlbumFragment() }

    fun AlbumDetailsScreen(album: Album) = FragmentScreen {
        AlbumDetailsFragment.getInstance(album)
    }

    fun FavoriteAlbumsScreen() = FragmentScreen { FavoriteAlbumsFragment() }
}