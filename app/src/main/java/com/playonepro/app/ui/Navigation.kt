package com.playonepro.app.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.playonepro.app.ui.screens.ActivationScreen
import com.playonepro.app.ui.screens.ChannelsScreen
import com.playonepro.app.ui.screens.HomeScreen
import com.playonepro.app.ui.screens.PlayerScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "activation") {
        composable("activation") {
            ActivationScreen(onActivateClick = { navController.navigate("home") })
        }
        composable("home") {
            HomeScreen()
        }
        composable("channels") {
            ChannelsScreen()
        }
        composable("player") {
            PlayerScreen()
        }
    }
}
