package com.playonepro.app.data.repository

import com.playonepro.app.data.api.ApiService
import com.playonepro.app.data.model.EpgEntry
import javax.inject.Inject

class EpgRepository @Inject constructor(private val api: ApiService) {
    suspend fun getEpg(channelId: String): List<EpgEntry> = api.getEpg(channelId)
}