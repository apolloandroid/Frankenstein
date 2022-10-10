package com.example.itunesmvp.ui.searchalbum

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import com.example.itunesmvp.databinding.FragmentSearchAlbumsBinding
import com.example.itunesmvp.domain.Album
import moxy.MvpAppCompatFragment
import moxy.MvpView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType
import org.koin.android.ext.android.inject

@StateStrategyType(AddToEndSingleStrategy::class)
interface SearchAlbumView : MvpView {
    @StateStrategyType(SkipStrategy::class)
    fun setProgressBarVisibility(isVisible: Boolean)

    fun updateAlbumsList(albums: List<Album>)

    fun setAlbumsRecyclerVisibility(isVisible: Boolean)
}

class SearchAlbumFragment : MvpAppCompatFragment(), SearchAlbumView {

    private lateinit var binding: FragmentSearchAlbumsBinding
    private lateinit var adapter: SearchAlbumsAdapter

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpSearchEditText()
        setUpAlbumsRecyclerView()
    }

    override fun setProgressBarVisibility(isVisible: Boolean) {
        binding.progressLoadAlbums.isVisible = isVisible
    }

    override fun updateAlbumsList(albums: List<Album>) = adapter.submitList(albums)

    override fun setAlbumsRecyclerVisibility(isVisible: Boolean) {
        binding.recyclerSearchResults.isVisible = isVisible
    }

    @ProvidePresenter
    fun providePresenter(): SearchAlbumPresenter {
        val presenter: SearchAlbumPresenter by inject()
        return presenter
    }

    private fun setUpSearchEditText() = binding.editSearch.doAfterTextChanged {
        presenter.onSearchQueryChanged(it.toString())
    }

    private fun setUpAlbumsRecyclerView() {
        adapter = SearchAlbumsAdapter(presenter::onAlbumClicked)
        binding.recyclerSearchResults.adapter = adapter
    }
}