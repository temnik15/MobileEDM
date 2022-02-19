package ru.rosystem.mobileedm.feature.auth.contract

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.rosystem.mobileedm.feature.auth.ui.AuthScreen
import ru.rosystem.mobileedm.feature.sign.ui.LoginScreen

internal sealed class AuthScreen(val route: String) {
    object Home : AuthScreen("${AuthScreen::class.java}.Home")
}

internal fun NavGraphBuilder.authGraph(route: String, navController: NavController) {
    navigation(AuthScreen.Home.route, route) {
        composable(AuthScreen.Home.route) { AuthScreen(navController = navController) }
    }
}