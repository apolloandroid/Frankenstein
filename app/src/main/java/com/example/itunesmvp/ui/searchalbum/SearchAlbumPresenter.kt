package com.example.itunesmvp.ui.searchalbum

import com.example.itunesmvp.data.album.AlbumRepository
import com.example.itunesmvp.domain.Album
import com.example.itunesmvp.navigation.Screens
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

    companion object {
        private const val TIME_OUT = 300L
    }

    private val compositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

    fun onSearchQueryChanged(albumName: String) {
        viewState.setProgressBarVisibility(true)
        albumRepository.getAlbumsByKeyWordFromRemote(albumName)
            .debounce(TIME_OUT, TimeUnit.MILLISECONDS)
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

    fun onAlbumClicked(album: Album) = router.navigateTo(Screens.albumDetailsFragment(album))
}