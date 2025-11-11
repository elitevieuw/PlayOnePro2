package com.playonepro.app.domain.usecase

import com.playonepro.app.data.model.ActivationRequest
import com.playonepro.app.data.model.ActivationResponse
import com.playonepro.app.data.repository.AuthRepository
import javax.inject.Inject

class ActivateDeviceUseCase @Inject constructor(private val authRepository: AuthRepository) {
    suspend operator fun invoke(request: ActivationRequest): ActivationResponse {
        return authRepository.activateDevice(request)
    }
}