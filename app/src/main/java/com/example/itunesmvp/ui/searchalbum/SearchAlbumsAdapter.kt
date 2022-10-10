package com.example.itunesmvp.ui.searchalbum

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.itunesmvp.R
import com.example.itunesmvp.databinding.ItemAlbumSearchAlbumsBinding
import com.example.itunesmvp.domain.Album

class SearchAlbumsAdapter(
    private val onAlbumClick: (album: Album) -> Unit
) : ListAdapter<Album, SearchAlbumsAdapter.AlbumViewHolder>(AlbumsDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAlbumSearchAlbumsBinding.inflate(layoutInflater, parent, false)
        return AlbumViewHolder(binding, onAlbumClick)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class AlbumViewHolder(
        private val binding: ItemAlbumSearchAlbumsBinding,
        private val onAlbumClick: (album: Album) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(album: Album) {
            binding.apply {
                root.setOnClickListener { onAlbumClick(album) }
                textAlbumName.text = album.name
                textArtistName.text = album.artistName
                Glide.with(root.context)
                    .load(album.coverUrl)
                    .placeholder(R.drawable.progress_bar_loading)
                    .into(imageAlbumCover)
            }
        }
    }

    private class AlbumsDiffCallBack : DiffUtil.ItemCallback<Album>() {
        override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean =
            oldItem.name == newItem.name
    }
}