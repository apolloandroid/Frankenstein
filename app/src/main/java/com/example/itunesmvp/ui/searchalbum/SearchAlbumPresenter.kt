package com.example.itunesmvp.ui.searchalbum

import com.example.itunesmvp.data.album.AlbumRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class SearchAlbumPresenter(
    private val albumRepository: AlbumRepository
) : MvpPresenter<SearchAlbumView>() {

    private val compositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    fun onSearchQueryChanged(albumName: String) {
        albumRepository.getAlbumsByName(albumName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy { albums -> viewState.showAlbums(albums) }
            .addTo(compositeDisposable)
    }
}