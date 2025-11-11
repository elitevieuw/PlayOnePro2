package com.playonepro.app.data.model

data class EpgEntry(
    val id: String,
    val channelId: String,
    val programTitle: String,
    val startTime: Long,
    val endTime: Long,
    val description: String?
)