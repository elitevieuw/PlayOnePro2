package com.playonepro.app.data.api

import retrofit2.http.GET
import retrofit2.http.Query
import com.playonepro.app.data.model.Channel
import com.playonepro.app.data.model.EpgEntry
import com.playonepro.app.data.model.Playlist
import com.playonepro.app.data.model.ActivationResponse

interface ApiService {
    @GET("channels")
    suspend fun getChannels(@Query("token") token: String): List<Channel>

    @GET("epg")
    suspend fun getEpg(@Query("channelId") channelId: String): List<EpgEntry>

    @GET("playlist")
    suspend fun getPlaylist(@Query("token") token: String): Playlist

    @GET("activate")
    suspend fun activateDevice(@Query("deviceId") deviceId: String, @Query("activationCode") activationCode: String): ActivationResponse
}