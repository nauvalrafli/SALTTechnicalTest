package com.example.salttechnicaltest.ui.screen.IScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController

interface Screen {
    val title: String
    val routeName: String
    val isLoading : MutableState<Boolean>
        get() = mutableStateOf(false)
    val isDismissableLoading : Boolean
        get() = false

    @Composable
    fun Screen(navController: NavController)

//  TODO : Made without args, need to check --> (BaseScreen(navController, args))
    @Composable
    fun BaseScreen(navController: NavController) {
        Screen(navController = navController)
        showLoading()
    }

    @Composable
    fun showLoading() {
        if (isLoading.value) Dialog(onDismissRequest = {
            isLoading.value = false
        }) {
            Box(
                modifier = Modifier.fillMaxSize().background(Color.Black.copy(alpha = 0.4f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Loading . . .\nPlease Wait",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = 30.sp
                )
            }
        }
    }
}