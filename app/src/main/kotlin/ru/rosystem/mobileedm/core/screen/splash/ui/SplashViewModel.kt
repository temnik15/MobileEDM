package ru.rosystem.mobileedm.core.screen.splash.ui

import android.content.Intent
import android.content.pm.PackageManager
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import ru.rosystem.mobileedm.core.navigation.MainScreen
import ru.rosystem.mobileedm.rutoken.utils.PcscChecker

internal class SplashViewModel(private val packageManager: PackageManager) : ViewModel() {

    fun getStartDestination(): String {
        return MainScreen.Auth.route
    }


    fun checkRuTokenService(): Boolean =
        PcscChecker.checkPcscInstallation(packageManager)

}