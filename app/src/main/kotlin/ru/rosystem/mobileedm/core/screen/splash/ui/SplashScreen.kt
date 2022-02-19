package ru.rosystem.mobileedm.core.screen.splash.ui

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavController
import ru.rosystem.mobileedm.AppPlugin
import ru.rosystem.mobileedm.R
import ru.rosystem.mobileedm.common.ui.theme.DefaultBackgroundGradientEndColor
import ru.rosystem.mobileedm.common.ui.theme.DefaultBackgroundGradientStartColor
import ru.rosystem.mobileedm.common.utils.clearDestination
import ru.rosystem.mobileedm.core.screen.load_dialog.LoadDialog
import ru.rosystem.mobileedm.core.screen.splash.di.DaggerSplashComponent
import ru.rosystem.mobileedm.rutoken.utils.PcscChecker
import ru.rosystem.mobileedm.rutoken.utils.marketURI
import ru.rosystem.mobileedm.rutoken.utils.marketURL


@Composable
internal fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel = DaggerSplashComponent
        .factory()
        .create(AppPlugin.getAppComponent(), LocalViewModelStoreOwner.current!!)
        .viewModel
) {
    val activity = LocalContext.current as Activity
    var needShowLoadServiceDialog by remember {
        mutableStateOf(false)
    }


    LaunchedEffect(Unit) {
        if (viewModel.checkRuTokenService()) {
            navController.navigate(viewModel.getStartDestination()) {
                clearDestination()
                launchSingleTop = true
            }
        } else needShowLoadServiceDialog = true

    }
    SplashScreenContent(needShowLoadServiceDialog, { activity.finish() }, {
        try {
            activity.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(marketURI + PcscChecker.PCSC_PACKAGE_NAME)
                )
            )
        } catch (e: ActivityNotFoundException) {
            activity.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(marketURL + PcscChecker.PCSC_PACKAGE_NAME)
                )
            )
        }
        activity.finish()
    })
}

@Composable
private fun SplashScreenContent(
    needShowLoadServiceDialog: Boolean,
    dialogDismiss: () -> Unit,
    dialogLoad: () -> Unit
) {
    Box(
        Modifier
            .fillMaxSize()
            .background(
                Brush.radialGradient(
                    listOf(
                        DefaultBackgroundGradientEndColor,
                        DefaultBackgroundGradientStartColor
                    ),
                    tileMode = TileMode.Mirror
                )
            )
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "",
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.Center)
        )
        if (needShowLoadServiceDialog) LoadDialog(onDismiss = dialogDismiss, onLoad = dialogLoad)
    }
}


@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview() {
    //SplashScreenContent(false)
}