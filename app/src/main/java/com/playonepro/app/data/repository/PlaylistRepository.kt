package com.playonepro.app.data.repository

import com.playonepro.app.data.api.ApiService
import com.playonepro.app.data.model.Playlist
import javax.inject.Inject

class PlaylistRepository @Inject constructor(private val api: ApiService) {
    suspend fun getPlaylist(token: String): Playlist = api.getPlaylist(token)
}