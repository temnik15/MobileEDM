package ru.rosystem.mobileedm.rutoken.utils

import android.content.pm.PackageManager
import androidx.fragment.app.DialogFragment

object PcscChecker {
    internal const val PCSC_PACKAGE_NAME = "ru.rutoken"

    fun checkPcscInstallation(manager: PackageManager): Boolean {
        val packages = manager.getInstalledApplications(0)
        return packages.any { it.packageName == PCSC_PACKAGE_NAME }
//        if (!pcscInstalled) {
//            val newFragment: DialogFragment = PcscInstallDialogFragment()
//            newFragment.show(activity.supportFragmentManager, "PcscInstallFragment")
//        }
    }
}