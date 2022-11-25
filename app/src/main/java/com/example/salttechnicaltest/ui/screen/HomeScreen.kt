package com.example.salttechnicaltest.ui.screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.salttechnicaltest.data.model.local.User
import com.example.salttechnicaltest.ui.component.WidgetImage
import com.example.salttechnicaltest.ui.component.shimmer
import com.example.salttechnicaltest.ui.screen.IScreen.Screen
import com.example.salttechnicaltest.ui.theme.SALTTechnicalTestTheme
import com.example.salttechnicaltest.viewmodel.HomeViewModel

object HomeScreen : Screen {
    override val title: String = "Homepage"
    override val routeName: String = "home"

    @Composable
    override fun Screen(navController: NavController) {

        val homeViewModel : HomeViewModel = hiltViewModel()

        LaunchedEffect(true) {
            homeViewModel.getUserList {
                //TODO save token
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(20.dp)
            ) {
                items(if (homeViewModel.userList.isEmpty()) 10 else homeViewModel.userList.size) {
                    if(homeViewModel.userList.isEmpty()) {
                        userListItem(dummyUser, true)
                    } else {
                        val item = homeViewModel.userList[it]
                        userListItem(item, homeViewModel.userList.isEmpty())
                    }
                }
            }
        }

        BackHandler() {
            navController.popBackStack()
        }
    }
}

val dummyUser = User(1, "doe", "roe", "moe", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fpixabay.com%2Fimages%2Fsearch%2Fnature%2F&psig=AOvVaw0zFOOhlHK329HXMGeio5Uy&ust=1669397225852000&source=images&cd=vfe&ved=0CA8QjRxqFwoTCJDjzrarx_sCFQAAAAAdAAAAABAE")

@Composable
fun userListItem(
    item : User = User(),
    isLoading: Boolean
) {
    Column(
        modifier = Modifier
            .background(Color.Blue.copy(alpha = 0.1f), RoundedCornerShape(16.dp))
            .padding(8.dp)
            .shimmer(isVisible = isLoading)
    ) {
        WidgetImage(url = item.avatar, modifier = Modifier
            .height(150.dp)
            .width(150.dp))
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = item.first_name, color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Text(text = item.last_name, color = Color.Gray, fontSize = 12.sp)
        Text(text = item.email, color = Color.DarkGray, fontSize = 14.sp)
    }
}

@Preview
@Composable
fun PreviewHome() {
    SALTTechnicalTestTheme() {
        HomeScreen.Screen(navController = rememberNavController())
    }
}