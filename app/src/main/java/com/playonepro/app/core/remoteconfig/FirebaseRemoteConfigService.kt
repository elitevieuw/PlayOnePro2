package com.playonepro.app.core.remoteconfig

import android.util.Log
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.playonepro.app.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Firebase Remote Config implementation for dynamic feature flagging and A/B testing.
 * 
 * This service provides a production-ready implementation with:
 * - Automatic default value loading from XML
 * - Configurable fetch intervals for development and production
 * - Error handling and logging
 * - Coroutine-based async operations
 * - Thread-safe singleton pattern via Hilt
 * 
 * @property remoteConfig Firebase Remote Config instance injected via Hilt
 */
@Singleton
class FirebaseRemoteConfigService @Inject constructor(
    private val remoteConfig: FirebaseRemoteConfig
) : RemoteConfigService {

    companion object {
        private const val TAG = "RemoteConfigService"
        private const val FETCH_INTERVAL_DEV = 0L // Immediate fetch for development
        private const val FETCH_INTERVAL_PROD = 3600L // 1 hour for production
    }

    init {
        setupRemoteConfig()
    }

    /**
     * Initialize Remote Config with default settings and values.
     */
    private fun setupRemoteConfig() {
        try {
            // Configure fetch settings
            val configSettings = FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(FETCH_INTERVAL_DEV)
                .build()
            
            remoteConfig.setConfigSettingsAsync(configSettings)
            
            // Load default values from XML
            remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
            
            Log.d(TAG, "Remote Config initialized successfully")
        } catch (e: Exception) {
            Log.e(TAG, "Error initializing Remote Config", e)
        }
    }

    /**
     * Fetch and activate the latest remote config values from Firebase.
     * This should be called on app startup or when you want to refresh config values.
     * 
     * @return true if fetch and activation was successful, false otherwise
     */
    override suspend fun fetchAndActivate(): Boolean = withContext(Dispatchers.IO) {
        try {
            val result = remoteConfig.fetchAndActivate().await()
            Log.d(TAG, "Fetch and activate result: $result")
            result
        } catch (e: Exception) {
            Log.e(TAG, "Error fetching remote config", e)
            false
        }
    }

    /**
     * Check if a feature is enabled.
     * Returns the boolean value from Remote Config, falling back to default if not available.
     * 
     * @param feature The feature flag to check
     * @return true if feature is enabled, false otherwise
     */
    override fun isFeatureEnabled(feature: Feature): Boolean {
        return try {
            val enabled = remoteConfig.getBoolean(feature.key)
            Log.d(TAG, "Feature ${feature.name} (${feature.key}): $enabled")
            enabled
        } catch (e: Exception) {
            Log.e(TAG, "Error getting feature ${feature.name}", e)
            false // Safe default
        }
    }

    /**
     * Get a string value from Remote Config.
     * 
     * @param key The configuration key
     * @return String value or empty string if not found
     */
    override fun getString(key: String): String {
        return try {
            val value = remoteConfig.getString(key)
            Log.d(TAG, "Get string for key '$key': $value")
            value
        } catch (e: Exception) {
            Log.e(TAG, "Error getting string for key '$key'", e)
            ""
        }
    }

    /**
     * Get a JSON configuration string from Remote Config.
     * Useful for complex configurations that need to be parsed.
     * 
     * @param key The configuration key
     * @return JSON string or empty object if not found
     */
    override fun getJsonConfig(key: String): String {
        return try {
            val json = remoteConfig.getString(key)
            Log.d(TAG, "Get JSON for key '$key': $json")
            json.ifEmpty { "{}" }
        } catch (e: Exception) {
            Log.e(TAG, "Error getting JSON for key '$key'", e)
            "{}"
        }
    }

    /**
     * Get a long value from Remote Config.
     * Useful for numeric configurations like timeouts or limits.
     */
    fun getLong(key: String, defaultValue: Long = 0L): Long {
        return try {
            remoteConfig.getLong(key)
        } catch (e: Exception) {
            Log.e(TAG, "Error getting long for key '$key'", e)
            defaultValue
        }
    }

    /**
     * Get a double value from Remote Config.
     * Useful for decimal configurations like percentages.
     */
    fun getDouble(key: String, defaultValue: Double = 0.0): Double {
        return try {
            remoteConfig.getDouble(key)
        } catch (e: Exception) {
            Log.e(TAG, "Error getting double for key '$key'", e)
            defaultValue
        }
    }
}
