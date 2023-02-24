package com.example.itunesmvp.ui.favoriteAlbums.root

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.itunesmvp.R
import com.example.itunesmvp.ui.base.RootFragment
import moxy.MvpView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.inject

class RootFavoriteAlbumsFragment : RootFragment<RootFavoriteAlbumsPresenter>() {

    override val fragmentContainerId: Int = R.id.layout_container_favorite_albums

    @InjectPresenter
    override lateinit var presenter: RootFavoriteAlbumsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_root_favorite_albums, container, false)
    }

    @ProvidePresenter
    override fun providePresenter(): RootFavoriteAlbumsPresenter {
        val presenter by inject<RootFavoriteAlbumsPresenter>()
        return presenter
    }
}