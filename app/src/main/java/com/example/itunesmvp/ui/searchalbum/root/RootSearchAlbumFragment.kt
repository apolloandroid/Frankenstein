package com.example.itunesmvp.ui.searchalbum.root

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

interface RootSearchAlbumView : MvpView

class RootSearchAlbumFragment : RootFragment<RootSearchAlbumPresenter>(), RootSearchAlbumView {

    override val fragmentContainerId: Int = R.id.layout_container_search_album

    @InjectPresenter
    override lateinit var presenter: RootSearchAlbumPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_root_search_album, container, false)
    }

    @ProvidePresenter
    override fun providePresenter(): RootSearchAlbumPresenter {
        val presenter by inject<RootSearchAlbumPresenter>()
        return presenter
    }
}