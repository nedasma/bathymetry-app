package com.example.bathymetryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bathymetryapp.bathymetry.ui.BathymetryListScreen
import com.example.bathymetryapp.login.ui.LoginScreen
import com.example.bathymetryapp.ui.theme.BathymetryAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            BathymetryAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login_screen"
                    ) {
                        composable("login_screen") {
                            LoginScreen(
                                modifier = Modifier.padding(innerPadding),
                                onNavigate = navController::navigate
                            )
                        }
                        composable(
                            route = "scans_list_screen/{token}",
                            arguments = listOf(
                                navArgument(name = "token") {
                                    type = NavType.StringType
                                    nullable = false
                                }
                            )
                        ) {
                            BathymetryListScreen(
                                modifier = Modifier.padding(innerPadding),
                            )
                        }
                    }
                }
            }
        }
    }
}