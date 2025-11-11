package com.playonepro.app.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.Date

/**
 * Device data model for PlayOnePro activation system
 * Represents a device registered on playonepro.com
 */
@Entity(tableName = "devices")
data class Device(
    @PrimaryKey
    @SerializedName("device_id")
    val deviceId: String,
    
    @SerializedName("mac_address")
    val macAddress: String,
    
    @SerializedName("activation_code")
    val activationCode: String? = null,
    
    @SerializedName("is_activated")
    val isActivated: Boolean = false,
    
    @SerializedName("license_type")
    val licenseType: LicenseType = LicenseType.NONE,
    
    @SerializedName("expiry_date")
    val expiryDate: Date? = null,
    
    @SerializedName("device_name")
    val deviceName: String,
    
    @SerializedName("platform")
    val platform: String = "Android",
    
    @SerializedName("model")
    val model: String,
    
    @SerializedName("android_version")
    val androidVersion: String,
    
    @SerializedName("app_version")
    val appVersion: String,
    
    @SerializedName("created_at")
    val createdAt: Date = Date(),
    
    @SerializedName("updated_at")
    val updatedAt: Date = Date(),
    
    @SerializedName("reseller_id")
    val resellerId: String? = null
)

enum class LicenseType {
    @SerializedName("none")
    NONE,
    
    @SerializedName("monthly")
    MONTHLY,
    
    @SerializedName("lifetime")
    LIFETIME
}

/**
 * Activation request payload for API
 */
data class ActivationRequest(
    @SerializedName("mac_address")
    val macAddress: String,
    
    @SerializedName("device_id")
    val deviceId: String,
    
    @SerializedName("activation_code")
    val activationCode: String,
    
    @SerializedName("platform")
    val platform: String,
    
    @SerializedName("model")
    val model: String,
    
    @SerializedName("android_version")
    val androidVersion: String,
    
    @SerializedName("app_version")
    val appVersion: String
)

/**
 * Activation response from API
 */
data class ActivationResponse(
    @SerializedName("success")
    val success: Boolean,
    
    @SerializedName("message")
    val message: String,
    
    @SerializedName("device")
    val device: Device? = null,
    
    @SerializedName("auth_token")
    val authToken: String? = null,
    
    @SerializedName("license_type")
    val licenseType: LicenseType? = null,
    
    @SerializedName("expiry_date")
    val expiryDate: Date? = null
)
