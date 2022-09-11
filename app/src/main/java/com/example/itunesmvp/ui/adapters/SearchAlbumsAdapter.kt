package com.example.itunesmvp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.itunesmvp.databinding.ItemAlbumSearchAlbumsBinding
import com.example.itunesmvp.domain.Album

class SearchAlbumsAdapter :
    ListAdapter<Album, SearchAlbumsAdapter.AlbumViewHolder>(AlbumsDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemAlbumSearchAlbumsBinding.inflate(layoutInflater, parent, false)
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class AlbumViewHolder(private val binding: ItemAlbumSearchAlbumsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(album: Album) {
            binding.textAlbumName.text = album.name
            binding.textArtistName.text = album.artistName
        }
    }

    private class AlbumsDiffCallBack : DiffUtil.ItemCallback<Album>() {
        override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean =
            oldItem.name == newItem.name
    }
}