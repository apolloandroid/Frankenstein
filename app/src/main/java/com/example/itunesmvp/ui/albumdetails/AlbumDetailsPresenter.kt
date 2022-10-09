package com.example.itunesmvp.ui.albumdetails

import com.example.itunesmvp.data.track.TrackRepository
import com.example.itunesmvp.domain.Album
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class AlbumDetailsPresenter(
    private val album: Album,
    private val trackRepository: TrackRepository
) : MvpPresenter<AlbumDetailsView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setToolbar(album.name)
        viewState.setAlbumCover(album.coverUrl)
    }
}