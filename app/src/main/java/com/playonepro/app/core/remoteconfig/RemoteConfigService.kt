package com.playonepro.app.core.remoteconfig

/**
 * Remote Config Service interface for dynamic feature flagging and A/B testing.
 * Provides abstraction layer for Firebase Remote Config implementation.
 */
interface RemoteConfigService {
    /**
     * Check if a specific feature is enabled.
     * @param feature The feature to check
     * @return true if feature is enabled, false otherwise
     */
    fun isFeatureEnabled(feature: Feature): Boolean
    
    /**
     * Get JSON configuration for a given key.
     * @param key The configuration key
     * @return JSON string configuration
     */
    fun getJsonConfig(key: String): String
    
    /**
     * Get string value for a given key.
     * @param key The configuration key
     * @return String configuration value
     */
    fun getString(key: String): String
    
    /**
     * Fetch and activate the latest remote config values.
     * @return true if activation was successful, false otherwise
     */
    suspend fun fetchAndActivate(): Boolean
}
