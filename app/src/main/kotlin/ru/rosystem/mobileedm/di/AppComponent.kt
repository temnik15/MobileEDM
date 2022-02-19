package ru.rosystem.mobileedm.di

import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import dagger.BindsInstance
import dagger.Component


@Component(modules = [AppModule::class])
@AppScope
interface AppComponent {

    val context: Context

    val packageManager: PackageManager

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): AppComponent
    }
}