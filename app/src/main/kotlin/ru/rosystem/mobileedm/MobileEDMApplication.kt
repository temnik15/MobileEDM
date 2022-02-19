package ru.rosystem.mobileedm

import android.app.Application

@Suppress("unused")
internal class MobileEDMApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        AppPlugin.initAppComponent(this)
    }
}