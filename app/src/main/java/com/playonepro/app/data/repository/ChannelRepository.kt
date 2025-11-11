package com.playonepro.app.data.repository

import com.playonepro.app.data.api.ApiService
import com.playonepro.app.data.model.Channel
import javax.inject.Inject

class ChannelRepository @Inject constructor(private val api: ApiService) {
    suspend fun getChannels(token: String): List<Channel> = api.getChannels(token)
}