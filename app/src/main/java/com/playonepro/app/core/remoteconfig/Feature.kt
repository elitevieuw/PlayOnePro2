package com.playonepro.app.core.remoteconfig

/**
 * Feature flags enum for remote configuration.
 * Each feature has a unique key that maps to Firebase Remote Config.
 */
enum class Feature(val key: String) {
    /**
     * DVR (Digital Video Recording) feature.
     * Controls whether users can record live streams.
     */
    DVR("dvr_enabled"),
    
    /**
     * New Player UI feature.
     * Enables the new redesigned player interface.
     */
    NEW_PLAYER_UI("new_player_ui_enabled"),
    
    /**
     * Picture-in-Picture mode feature.
     * Allows users to watch content in a floating window.
     */
    PIP_MODE("pip_mode_enabled"),
    
    /**
     * Offline downloads feature.
     * Enables content download for offline viewing.
     */
    OFFLINE_DOWNLOADS("offline_downloads_enabled"),
    
    /**
     * Live chat feature.
     * Shows live chat during streaming.
     */
    LIVE_CHAT("live_chat_enabled")
}
