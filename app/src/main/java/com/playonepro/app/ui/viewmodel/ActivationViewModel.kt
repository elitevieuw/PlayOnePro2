package com.playonepro.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.playonepro.app.data.local.DeviceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ActivationViewModel @Inject constructor(
    private val deviceManager: DeviceManager
) : ViewModel() {

    fun getMacAddress(): String {
        return deviceManager.getMacAddress()
    }

    fun getDeviceKey(): String {
        return deviceManager.getDeviceKey()
    }

    fun onActivateClick() {
        // TODO: Implement activation logic
    }
}
