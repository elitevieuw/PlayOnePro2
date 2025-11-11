package com.playonepro.app.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.playonepro.app.data.model.Channel
import com.playonepro.app.data.repository.ChannelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChannelsViewModel @Inject constructor(
    private val channelRepository: ChannelRepository
) : ViewModel() {
    private val _state = MutableStateFlow(ChannelsUIState())
    val state: StateFlow<ChannelsUIState> = _state

    fun fetchChannels(token: String) {
        viewModelScope.launch {
            _state.value = _state.value.copy(loading = true)
            try {
                val channels = channelRepository.getChannels(token)
                _state.value = ChannelsUIState(channels = channels)
            } catch (e: Exception) {
                _state.value = _state.value.copy(error = e.message, loading = false)
            }
        }
    }
}

data class ChannelsUIState(
    val channels: List<Channel> = emptyList(),
    val error: String? = null,
    val loading: Boolean = false
)