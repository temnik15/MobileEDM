package ru.rosystem.mobileedm.feature.sign.contract

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.rosystem.mobileedm.feature.sign.ui.LoginScreen

internal sealed class SignScreen(val route: String) {
    object Home : SignScreen("${SignScreen::class.java}.Home")
}

internal fun NavGraphBuilder.signGraph(route: String, navController: NavController) {
    navigation(SignScreen.Home.route, route) {
        composable(SignScreen.Home.route) { LoginScreen(navController = navController) }
    }
}