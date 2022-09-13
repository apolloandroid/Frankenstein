package com.example.itunesmvp.ui.albumdetails

import com.example.itunesmvp.data.album.AlbumRepository
import com.example.itunesmvp.data.track.TrackRepository
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class AlbumDetailsPresenter(
    private val albumRepository: AlbumRepository,
    private val trackRepository: TrackRepository
) : MvpPresenter<AlbumDetailsView>() {
}