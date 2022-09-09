package com.example.itunesmvp.ui.searchalbum

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.itunesmvp.databinding.FragmentSearchAlbumsBinding

interface SearchAlbumView

class SearchAlbumFragment : Fragment(), SearchAlbumView {

    private lateinit var binding: FragmentSearchAlbumsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchAlbumsBinding.inflate(inflater, container, false)
        return binding.root
    }
}