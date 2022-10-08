package com.example.itunesmvp.ui.searchalbum

import android.util.Log
import com.example.itunesmvp.data.album.AlbumRepository
import com.example.itunesmvp.domain.Album
import com.example.itunesmvp.navigation.AlbumDetailsScreen
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import java.util.concurrent.TimeUnit

@InjectViewState
class SearchAlbumPresenter(
    private val router: Router,
    private val albumRepository: AlbumRepository
) : MvpPresenter<SearchAlbumView>() {

    private val compositeDisposable = CompositeDisposable()

    private var isNeedToRefreshAlbums = true

    override fun destroyView(view: SearchAlbumView?) {
        Log.d("TAG", "destroyView")
        compositeDisposable.clear()
        super.destroyView(view)
    }

    override fun attachView(view: SearchAlbumView?) {
        super.attachView(view)
        Log.d("TAG", "attachView")
        isNeedToRefreshAlbums = true
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        Log.d("TAG", "onFirstViewAttach")
    }

    override fun detachView(view: SearchAlbumView?) {
        super.detachView(view)
        Log.d("TAG", "detachView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "presenter onDestroy")
    }

    fun onSearchQueryChanged(albumName: String) {
        if (isNeedToRefreshAlbums) {
            viewState.setProgressBarVisibility(true)
            albumRepository.getAlbumsByKeyWord(albumName)
                .debounce(300, TimeUnit.MILLISECONDS)
                .distinctUntilChanged()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy { albums ->
                    viewState.updateAlbumsList(albums)
                    viewState.setAlbumsRecyclerVisibility(albums.isNotEmpty())
                    viewState.setProgressBarVisibility(false)
                }
                .addTo(compositeDisposable)
        }
    }

    fun onAlbumClicked(album: Album) {
//        isNeedToRefreshAlbums = false
        router.navigateTo(AlbumDetailsScreen)
    }
}