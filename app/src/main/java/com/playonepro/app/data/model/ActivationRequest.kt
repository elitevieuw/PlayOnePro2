package com.playonepro.app.data.model

data class ActivationRequest(
    val deviceId: String,
    val activationCode: String
)

data class ActivationResponse(
    val success: Boolean,
    val token: String?,
    val error: String?
)