package com.google.sample_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.sample_jetpack_compose.home.HomeScreen
import com.google.sample_jetpack_compose.menu.MenuScreen
import com.google.sample_jetpack_compose.ui.theme.Sample_jetpack_composeTheme

@ExperimentalAnimationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Sample_jetpack_composeTheme(darkTheme = true) {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "home") {
                    composable(route = "home") {
                        HomeScreen(
                            onCategoryClick = { navController.navigate("menu") },
                            onMenuItemClick = { navController.navigate("menu") },
                        )
                    }

                    composable(route = "menu") {
                        MenuScreen(
                            onBackClick = { navController.navigateUp() }
                        )
                    }
                }
            }
        }
    }
}