package com.example.itunesmvp.ui.albumdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.itunesmvp.databinding.FragmentAlbumDetailsBinding
import moxy.MvpAppCompatFragment
import moxy.MvpView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import org.koin.android.ext.android.inject

interface AlbumDetailsView : MvpView

class AlbumDetailsFragment : MvpAppCompatFragment(), AlbumDetailsView {

    private lateinit var binding: FragmentAlbumDetailsBinding

    @InjectPresenter
    lateinit var presenter: AlbumDetailsPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlbumDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    @ProvidePresenter
    fun providePresenter(): AlbumDetailsPresenter {
        val presenter: AlbumDetailsPresenter by inject()
        return presenter
    }
}