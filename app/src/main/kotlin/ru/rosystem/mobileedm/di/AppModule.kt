package ru.rosystem.mobileedm.di

import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import dagger.Module
import dagger.Provides

@Module
internal class AppModule {

    @AppScope
    @Provides
    fun provideContext(application: Application): Context = application.applicationContext

    @AppScope
    @Provides
    fun providePackageManager(context: Context): PackageManager = context.packageManager
}