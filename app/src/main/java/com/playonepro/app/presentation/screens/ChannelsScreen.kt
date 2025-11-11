package com.playonepro.app.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.playonepro.app.presentation.viewmodel.ChannelsViewModel

@Composable
fun ChannelsScreen(viewModel: ChannelsViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = "Kanalen", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        if (state.loading) {
            CircularProgressIndicator()
        } else {
            LazyColumn {
                items(state.channels) { channel ->
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // hier kan logo/image van channel met Coil komen
                        Text(text = channel.name, style = MaterialTheme.typography.bodyLarge)
                    }
                }
            }
        }
        if (state.error != null) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = state.error ?: "", color = MaterialTheme.colorScheme.error)
        }
    }
}