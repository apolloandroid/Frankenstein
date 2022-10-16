package com.example.itunesmvp.ui.albumdetails

import com.example.itunesmvp.domain.Track


data class TrackItem(
    val name: String,
    val number: Int,
    val duration: String
) {

    companion object {
        private const val DURATION_FORMAT = "%d:%02d"

        fun mapFromDomain(track: Track): TrackItem = TrackItem(
            name = track.name,
            number = track.number,
            duration = getDuration(track.timeMillis)
        )

        private fun getDuration(timeMillis: Int): String {
            val totalSeconds = timeMillis / 1000
            val trackMinutes = totalSeconds / 60
            val trackSeconds = totalSeconds % 60
            return String.format(DURATION_FORMAT, trackMinutes, trackSeconds)
        }
    }
}
