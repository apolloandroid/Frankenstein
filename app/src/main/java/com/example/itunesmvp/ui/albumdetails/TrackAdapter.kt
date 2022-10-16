package com.example.itunesmvp.ui.albumdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.itunesmvp.databinding.ItemTrackBinding

class TrackAdapter : ListAdapter<TrackItem, TrackAdapter.ViewHolder>(TracksDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTrackBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class ViewHolder(private val binding: ItemTrackBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(track: TrackItem) {
            binding.apply {
                textName.text = track.name
                textNumber.text = track.number.toString()
                textDuration.text = track.duration
            }
        }
    }

    private class TracksDiffCallBack : DiffUtil.ItemCallback<TrackItem>() {

        override fun areItemsTheSame(oldItem: TrackItem, newItem: TrackItem): Boolean =
            oldItem.number == newItem.number

        override fun areContentsTheSame(oldItem: TrackItem, newItem: TrackItem): Boolean =
            oldItem == newItem
    }
}
