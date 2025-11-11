package com.playonepro.app.core.player

import android.content.Context
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem

class ExoPlayerManager(context: Context) {
    private val exoPlayer: ExoPlayer = ExoPlayer.Builder(context).build()

    fun play(streamUrl: String) {
        val mediaItem = MediaItem.fromUri(streamUrl)
        exoPlayer.setMediaItem(mediaItem)
        exoPlayer.prepare()
        exoPlayer.play()
    }

    fun stop() {
        exoPlayer.stop()
    }

    fun release() {
        exoPlayer.release()
    }

    fun getPlayer(): ExoPlayer {
        return exoPlayer
    }
}