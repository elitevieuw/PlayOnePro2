package com.playonepro.app.core.utils

object DeviceUtils {
    fun getDeviceId(): String {
        return android.os.Build.SERIAL ?: "device_unknown"
    }
}