package com.example.itunesmvp.ui.albumdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.itunesmvp.databinding.FragmentAlbumDetailsBinding
import com.example.itunesmvp.domain.Album
import moxy.MvpAppCompatFragment
import moxy.MvpView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

@StateStrategyType(AddToEndSingleStrategy::class)
interface AlbumDetailsView : MvpView {
    fun setToolbar(text: String)
    fun setAlbumCover(coverUrl: String)
    fun updateTracksList(tracks: List<TrackItem>)

    @StateStrategyType(SkipStrategy::class)
    fun setProgressBarVisibility(isVisible: Boolean)
}

class AlbumDetailsFragment : MvpAppCompatFragment(), AlbumDetailsView {

    private lateinit var binding: FragmentAlbumDetailsBinding
    private val trackAdapter = TrackAdapter()

    @InjectPresenter
    lateinit var presenter: AlbumDetailsPresenter

    companion object {
        private const val KEY_ALBUM = "key_album"

        fun getInstance(album: Album): AlbumDetailsFragment = AlbumDetailsFragment().apply {
            arguments = Bundle().apply {
                putSerializable(KEY_ALBUM, album)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAlbumDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTracksList()
    }

    override fun setToolbar(text: String) {
        with(binding.toolbar) {
            title = text
        }
    }

    override fun setAlbumCover(coverUrl: String) {
        Glide.with(requireContext()).load(coverUrl).into(binding.imageAlbumCover)
    }

    override fun updateTracksList(tracks: List<TrackItem>) = trackAdapter.submitList(tracks)

    override fun setProgressBarVisibility(isVisible: Boolean) {
        //  Implement
    }

    @Suppress("DEPRECATION")
    @ProvidePresenter
    fun providePresenter(): AlbumDetailsPresenter {
        val presenter: AlbumDetailsPresenter by inject {
            parametersOf(arguments?.getSerializable(KEY_ALBUM) as Album)
        }
        return presenter
    }

    private fun initTracksList() {
        binding.recyclerTracks.adapter = trackAdapter
    }
}