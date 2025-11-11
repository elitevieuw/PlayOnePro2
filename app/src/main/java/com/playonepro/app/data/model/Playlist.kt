package com.playonepro.app.data.model

data class Playlist(
    val id: String,
    val name: String,
    val channels: List<Channel>
)