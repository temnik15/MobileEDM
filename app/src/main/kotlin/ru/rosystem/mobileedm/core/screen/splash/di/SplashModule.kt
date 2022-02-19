package ru.rosystem.mobileedm.core.screen.splash.di

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.get
import dagger.Module
import dagger.Provides
import ru.rosystem.mobileedm.core.screen.splash.ui.SplashViewModel

@Module
internal class SplashModule {

    @Provides
    @SplashScope
    fun provideViewModel(
        owner: ViewModelStoreOwner,
        factory: SplashViewModelFactory
    ): SplashViewModel =
        ViewModelProvider(owner, factory).get()

}