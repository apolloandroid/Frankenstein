package com.example.itunesmvp.ui.searchalbum

import android.util.Log
import com.example.itunesmvp.data.album.AlbumRepository
import com.example.itunesmvp.ui.SearchAlbumView
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

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        Log.d("TAG", "onFirstViewAttach()")
        albumRepository.getAlbumsByName("Bulanova")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = {
                    viewState.showAlbums(it)
                },
                onError = {
                    Log.d("TAG", "$it")
                }
            ).addTo(compositeDisposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}