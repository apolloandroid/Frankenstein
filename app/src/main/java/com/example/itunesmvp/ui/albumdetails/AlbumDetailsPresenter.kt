package com.example.itunesmvp.ui.albumdetails

import com.example.itunesmvp.data.track.TrackRepository
import com.example.itunesmvp.domain.Album
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class AlbumDetailsPresenter(
    private val album: Album,
    private val trackRepository: TrackRepository
) : MvpPresenter<AlbumDetailsView>() {

    private val compositeDisposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.setToolbar(album.name)
        viewState.setAlbumCover(album.coverUrl)
        getTracks()
    }

    private fun getTracks() {
        viewState.setProgressBarVisibility(true)
        trackRepository.getAlbumTracks(album.collectionId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy { tracks ->
                viewState.updateTracksList(tracks)
                viewState.setProgressBarVisibility(false)
            }.addTo(compositeDisposable)
    }
}