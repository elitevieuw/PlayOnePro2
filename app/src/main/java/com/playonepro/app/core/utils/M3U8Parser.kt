package com.playonepro.app.core.utils

import com.playonepro.app.data.model.Channel
import com.playonepro.app.data.model.Playlist

object M3U8Parser {
    fun parseM3U8(content: String): Playlist {
        val lines = content.lines()
        val channels = mutableListOf<Channel>()
        var channelId = 0
        var channelName = ""
        var streamUrl = ""
        for (line in lines) {
            when {
                line.startsWith("#EXTINF") -> {
                    channelName = line.substringAfter(",").trim()
                }
                line.startsWith("http") -> {
                    streamUrl = line.trim()
                    channels.add(Channel(id = (channelId++).toString(), name = channelName, logoUrl = "", streamUrl = streamUrl, category = "IPTV"))
                }
            }
        }
        return Playlist(id = "default", name = "M3U8 Playlist", channels = channels)
    }
}