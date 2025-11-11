package com.playonepro.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.playonepro.app.domain.usecase.ActivateDeviceUseCase
import com.playonepro.app.data.model.ActivationRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActivationViewModel @Inject constructor(
    private val activateDeviceUseCase: ActivateDeviceUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(ActivationUIState())
    val state: StateFlow<ActivationUIState> = _state

    fun onActivationCodeChanged(code: String) {
        _state.value = _state.value.copy(activationCode = code, error = null)
    }

    fun activateDevice() {
        val code = _state.value.activationCode
        if (code.isBlank()) {
            _state.value = _state.value.copy(error = "Code mag niet leeg zijn.")
            return
        }
        viewModelScope.launch {
            try {
                val result = activateDeviceUseCase(ActivationRequest("device123", code))
                _state.value = _state.value.copy(success = result.success, error = result.error)
            } catch (ex: Exception) {
                _state.value = _state.value.copy(error = ex.message)
            }
        }
    }
}

data class ActivationUIState(
    val activationCode: String = "",
    val error: String? = null,
    val success: Boolean = false
) {
    val canActivate: Boolean get() = activationCode.isNotBlank()
}