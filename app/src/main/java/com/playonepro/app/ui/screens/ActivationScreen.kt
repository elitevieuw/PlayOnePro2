package com.playonepro.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.playonepro.app.ui.viewmodel.ActivationViewModel

@Composable
fun ActivationScreen(
    viewModel: ActivationViewModel = hiltViewModel(),
    onActivateClick: () -> Unit
) {
    val macAddress = viewModel.getMacAddress()
    val deviceKey = viewModel.getDeviceKey()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFF1A237E), Color(0xFF3949AB))
                )
            )
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "MAC Address",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = macAddress,
            color = Color.White,
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = "Device Key",
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = deviceKey,
            color = Color.White,
            fontSize = 24.sp
        )
        Spacer(modifier = Modifier.height(64.dp))
        Button(
            onClick = {
                viewModel.onActivateClick()
                onActivateClick()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
        ) {
            Text(text = "Activate", color = Color.Black)
        }
    }
}
