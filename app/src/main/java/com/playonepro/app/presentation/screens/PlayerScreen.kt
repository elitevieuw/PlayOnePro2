package com.playonepro.app.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.playonepro.app.presentation.viewmodel.PlayerViewModel

@Composable
fun PlayerScreen(viewModel: PlayerViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Live kanaal: " + state.channelName)
        Spacer(modifier = Modifier.height(16.dp))
        if (state.isPlaying) {
            // Player area: hier komt daadwerkelijke ExoPlayer composable/view
            Text(text = "Afspelen...", color = MaterialTheme.colorScheme.primary)
            Button(onClick = viewModel::stop) { Text("Stop") }
        } else {
            Button(onClick = viewModel::play) { Text("Start stream") }
        }
        if (state.error != null) {
            Text(text = state.error ?: "", color = MaterialTheme.colorScheme.error)
        }
    }
}