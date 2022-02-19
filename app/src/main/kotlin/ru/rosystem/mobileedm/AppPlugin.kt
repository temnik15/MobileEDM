package ru.rosystem.mobileedm

import android.app.Application
import ru.rosystem.mobileedm.di.AppComponent
import ru.rosystem.mobileedm.di.DaggerAppComponent

interface AppComponentHolder {
    fun getAppComponent(): AppComponent
}

internal object AppPlugin: AppComponentHolder {
    private lateinit var appComponent: AppComponent

    fun initAppComponent(application: Application) {
        appComponent = DaggerAppComponent
            .factory()
            .create(application)
    }

    override fun getAppComponent(): AppComponent = appComponent
}