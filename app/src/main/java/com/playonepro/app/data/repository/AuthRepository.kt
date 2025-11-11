package com.playonepro.app.data.repository

import com.playonepro.app.data.api.ApiService
import com.playonepro.app.data.model.ActivationRequest
import com.playonepro.app.data.model.ActivationResponse
import javax.inject.Inject

class AuthRepository @Inject constructor(private val api: ApiService) {
    suspend fun activateDevice(request: ActivationRequest): ActivationResponse {
        return api.activateDevice(request.deviceId, request.activationCode)
    }
}