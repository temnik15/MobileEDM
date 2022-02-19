package ru.rosystem.mobileedm.core.screen.splash.di

import android.content.pm.PackageManager
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.rosystem.mobileedm.core.screen.splash.ui.SplashViewModel
import javax.inject.Inject
import javax.inject.Provider

internal class SplashViewModelFactory @Inject constructor(
    private val packageManager: Provider<PackageManager>
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SplashViewModel(packageManager.get()) as T
    }
}