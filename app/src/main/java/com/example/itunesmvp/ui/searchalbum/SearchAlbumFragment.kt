package com.example.itunesmvp.ui.searchalbum

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import com.example.itunesmvp.databinding.FragmentSearchAlbumsBinding
import com.example.itunesmvp.domain.Album
import com.example.itunesmvp.ui.adapters.SearchAlbumsAdapter
import moxy.MvpAppCompatFragment
import moxy.MvpView
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import org.koin.android.ext.android.inject

@StateStrategyType(AddToEndSingleStrategy::class)
interface SearchAlbumView : MvpView {
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun setProgressBarVisibility(isVisible: Boolean)

    @StateStrategyType(OneExecutionStateStrategy::class)
    fun updateAlbumsList(albums: List<Album>)

    fun setAlbumsRecyclerVisibility(isVisible: Boolean)
}

class SearchAlbumFragment : MvpAppCompatFragment(), SearchAlbumView {

    private lateinit var binding: FragmentSearchAlbumsBinding
    private lateinit var adapter: SearchAlbumsAdapter

    @InjectPresenter
    lateinit var presenter: SearchAlbumPresenter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("TAG", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TAG", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("TAG", "onCreateView")
        binding = FragmentSearchAlbumsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TAG", "onViewCreated")
        setUpSearchEditText()
        setUpAlbumsRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("TAG", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("TAG", "onDetach")
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

    private fun setUpSearchEditText() {
//        binding.editSearch.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                TODO("Not yet implemented")
//            }
//
//            override fun afterTextChanged(p0: Editable?) {
//                TODO("Not yet implemented")
//            }
//
//        })
        binding.editSearch.doAfterTextChanged { presenter.onSearchQueryChanged(it.toString()) }
    }

    private fun setUpAlbumsRecyclerView() {
        adapter = SearchAlbumsAdapter(presenter::onAlbumClicked)
        binding.recyclerSearchResults.adapter = adapter
    }
}