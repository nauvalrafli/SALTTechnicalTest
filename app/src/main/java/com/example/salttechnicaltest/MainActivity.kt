package com.example.salttechnicaltest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.salttechnicaltest.ui.screen.HomeScreen
import com.example.salttechnicaltest.ui.screen.LoginScreen
import com.example.salttechnicaltest.ui.theme.SALTTechnicalTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            SALTTechnicalTestTheme() {
                NavHost(
                    navController = navController,
                    startDestination = LoginScreen.routeName
                ) {
                    composable(LoginScreen.routeName) {
                        LoginScreen.Screen(navController = navController)
                    }
                    composable(HomeScreen.routeName) {
                        HomeScreen.Screen(navController = navController)
                    }
                }
            }
        }
    }
}