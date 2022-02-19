package ru.rosystem.mobileedm.core.navigation

import android.annotation.SuppressLint

/** Корневая навигация MainActivity */
sealed class MainScreen(val route: String) {
    @SuppressLint("CustomSplashScreen")
    /** Стартовый экран */
    object SplashScreen : MainScreen("${MainScreen::class.java}.SplashScreen")
    object Home : MainScreen("${MainScreen::class.java}.Home")
    object Auth : MainScreen("${MainScreen::class.java}.Auth")
    object Reg : MainScreen("${MainScreen::class.java}.Reg")
}