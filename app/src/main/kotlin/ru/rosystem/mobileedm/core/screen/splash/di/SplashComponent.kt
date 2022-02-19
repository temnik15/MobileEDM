package ru.rosystem.mobileedm.core.screen.splash.di

import androidx.lifecycle.ViewModelStoreOwner
import dagger.BindsInstance
import dagger.Component
import ru.rosystem.mobileedm.core.screen.splash.ui.SplashViewModel
import ru.rosystem.mobileedm.di.AppComponent

@SplashScope
@Component(dependencies = [AppComponent::class], modules = [SplashModule::class])
internal interface SplashComponent {

    val viewModel: SplashViewModel

    @Component.Factory
    interface Factory {
        fun create(
            appComponent: AppComponent,
            @BindsInstance owner: ViewModelStoreOwner
        ): SplashComponent
    }
}