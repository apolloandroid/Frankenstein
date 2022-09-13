package com.example.itunesmvp.ui.searchalbum

import com.example.itunesmvp.data.album.AlbumRepository
import com.example.itunesmvp.domain.Album
import com.example.itunesmvp.navigation.AlbumDetailsScreen
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.kotlin.addTo
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter

@InjectViewState
class SearchAlbumPresenter(
    private val router: Router,
    private val albumRepository: AlbumRepository
) : MvpPresenter<SearchAlbumView>() {

    private val compositeDisposable = CompositeDisposable()
    private lateinit var getAlbumsByName: Disposable

    override fun destroyView(view: SearchAlbumView?) {
        compositeDisposable.clear()
        super.destroyView(view)
    }

    fun onSearchQueryChanged(albumName: String) {
        viewState.setProgressBarVisibility(true)
        if (::getAlbumsByName.isInitialized) {
            compositeDisposable.delete(getAlbumsByName)
            getAlbumsByName.dispose()
        }
        getAlbumsByName = albumRepository.getAlbumsByKeyWord(albumName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy { albums ->
                viewState.updateAlbumsList(albums)
                viewState.setAlbumsRecyclerVisibility(albums.isNotEmpty())
                viewState.setProgressBarVisibility(false)
            }
            .addTo(compositeDisposable)
    }

    fun onAlbumClicked(album: Album) = router.navigateTo(AlbumDetailsScreen)
}