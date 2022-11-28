package com.example.salttechnicaltest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.salttechnicaltest.data.datastore.DataStoreManager
import com.example.salttechnicaltest.data.datastore.dataStore
import com.example.salttechnicaltest.data.datastore.getValue
import com.example.salttechnicaltest.ui.screen.HomeScreen
import com.example.salttechnicaltest.ui.screen.LoginScreen
import com.example.salttechnicaltest.ui.theme.SALTTechnicalTestTheme
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.internal.notify
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor(
    val dataStoreManager: DataStoreManager
) : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            val context = LocalContext.current
            val token = dataStoreManager.token.getValue(context)

            LaunchedEffect(key1 = token) {
                navController.navigate(HomeScreen.routeName)
            }

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