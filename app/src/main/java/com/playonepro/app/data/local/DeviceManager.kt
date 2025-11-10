package com.playonepro.app.data.local

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DeviceManager @Inject constructor(@ApplicationContext context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun getMacAddress(): String {
        var macAddress = sharedPreferences.getString(KEY_MAC_ADDRESS, null)
        if (macAddress == null) {
            macAddress = generateMacAddress()
            sharedPreferences.edit().putString(KEY_MAC_ADDRESS, macAddress).apply()
        }
        return macAddress
    }

    fun getDeviceKey(): String {
        var deviceKey = sharedPreferences.getString(KEY_DEVICE_KEY, null)
        if (deviceKey == null) {
            deviceKey = generateDeviceKey()
            sharedPreferences.edit().putString(KEY_DEVICE_KEY, deviceKey).apply()
        }
        return deviceKey
    }

    fun saveAuthToken(token: String) {
        sharedPreferences.edit().putString(KEY_AUTH_TOKEN, token).apply()
    }

    fun getAuthToken(): String? {
        return sharedPreferences.getString(KEY_AUTH_TOKEN, null)
    }

    fun isActivated(): Boolean {
        return getAuthToken() != null
    }

    private fun generateMacAddress(): String {
        val random = java.util.Random()
        val lastThreeOctets = (0..2).joinToString(":") {
            String.format("%02X", random.nextInt(256))
        }
        return "00:1A:79:$lastThreeOctets"
    }

    private fun generateDeviceKey(): String {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 16).uppercase()
            .chunked(4)
            .joinToString("-")
    }

    companion object {
        private const val PREFS_NAME = "PlayOneProPrefs"
        private const val KEY_MAC_ADDRESS = "mac_address"
        private const val KEY_DEVICE_KEY = "device_key"
        private const val KEY_AUTH_TOKEN = "auth_token"
    }
}
