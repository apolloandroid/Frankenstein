package com.example.itunesmvp.ui.searchalbum

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.itunesmvp.databinding.FragmentSearchAlbumsBinding
import com.example.itunesmvp.domain.Album
import moxy.InjectViewState
import moxy.MvpAppCompatFragment
import moxy.MvpView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType
import org.koin.android.ext.android.inject

@StateStrategyType(AddToEndStrategy::class)
interface SearchAlbumView : MvpView {
    fun showAlbums(albums: List<Album>)
}

class SearchAlbumFragment : MvpAppCompatFragment(), SearchAlbumView {

    private lateinit var binding: FragmentSearchAlbumsBinding

    @InjectPresenter
    lateinit var presenter: SearchAlbumPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchAlbumsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun showAlbums(albums: List<Album>) {

    }

    @ProvidePresenter
    fun providePresenter(): SearchAlbumPresenter {
        val presenter: SearchAlbumPresenter by inject()
        Log.d("TAG", "activity presenter $presenter")
        return presenter
    }
}