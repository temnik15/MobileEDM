package ru.rosystem.mobileedm.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.rosystem.mobileedm.core.screen.load_dialog.LoadDialog
import ru.rosystem.mobileedm.core.screen.splash.ui.SplashScreen
import ru.rosystem.mobileedm.feature.auth.contract.authGraph
import ru.rosystem.mobileedm.feature.registration.contract.registrationGraph

/**
 * Корневая навигация MainActivity
 */
@Composable
internal fun MainActivityNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MainScreen.SplashScreen.route) {
        composable(MainScreen.SplashScreen.route) { SplashScreen(navController = navController) }
        registrationGraph(route = MainScreen.Reg.route, navController = navController)
        authGraph(MainScreen.Auth.route, navController)
    }
}