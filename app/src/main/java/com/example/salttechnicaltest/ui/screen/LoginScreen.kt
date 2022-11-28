package com.example.salttechnicaltest.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.salttechnicaltest.R
import com.example.salttechnicaltest.ui.screen.IScreen.Screen
import com.example.salttechnicaltest.viewmodel.LoginViewModel
import kotlinx.coroutines.runBlocking

object LoginScreen : Screen {
    override val title: String = "Login"
    override val routeName: String = "login"

    @Composable
    override fun Screen(navController: NavController) {

        val loginViewModel : LoginViewModel = hiltViewModel()

        val passwordVisible = remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
            ) {
                Text("Reqres", fontWeight = FontWeight.Bold, fontSize = 25.sp)
                Spacer(modifier = Modifier.height(24.dp))
                OutlinedTextField(
                    value = loginViewModel.email.value,
                    onValueChange = {
                        loginViewModel.email.value = it
                    },
                    label = {
                        Text("Username")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = {
                        Text(text = "Username")
                    }
                )
                Spacer(modifier = Modifier.height(12.dp))
                OutlinedTextField(
                    value = loginViewModel.password.value,
                    onValueChange = {
                        loginViewModel.password.value = it
                    },
                    label = {
                        Text("Password")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = if(passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    placeholder = {
                        Text(text = "Password")
                    },
                    trailingIcon = {
                        IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                            Icon(
                                painter = painterResource(id = if(passwordVisible.value) R.drawable.ic_baseline_visibility_24 else R.drawable.ic_baseline_visibility_off_24),
                                contentDescription = null
                            )
                        }
                    }
                )
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = {
                        runBlocking {
                            loginViewModel.login {
                                navController.navigate(HomeScreen.routeName)
                            }
                        }
                    },
                    modifier = Modifier
                        .background(Color.Blue, RoundedCornerShape(12.dp))
                        .fillMaxWidth()
                ) {
                    Text(text = "LOGIN", color = Color.White)
                }
                Spacer(modifier = Modifier.height(12.dp))
                Button(
                    onClick = {
                        runBlocking {
                            loginViewModel.register {
                                navController.navigate(HomeScreen.routeName)
                            }
                        }
                    },
                    modifier = Modifier
                        .background(Color.Blue.copy(alpha = 0.3f), RoundedCornerShape(12.dp))
                        .fillMaxWidth()
                ) {
                    Text(text = "Register", color = Color.White)
                }
            }
        }
    }
}