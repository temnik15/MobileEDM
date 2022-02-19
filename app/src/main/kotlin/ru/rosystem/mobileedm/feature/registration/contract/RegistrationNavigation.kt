package ru.rosystem.mobileedm.feature.registration.contract

import androidx.compose.material.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ru.rosystem.mobileedm.feature.registration.ui.RegistrationScreen

internal sealed class RegistrationScreen(val route: String) {
    object Home : RegistrationScreen("${RegistrationScreen::class.java}.Home")
}

internal fun NavGraphBuilder.registrationGraph(route: String, navController: NavController) {
    navigation(RegistrationScreen.Home.route, route) {
        composable(RegistrationScreen.Home.route) { RegistrationScreen(navController = navController) }
    }
}