package ru.rosystem.mobileedm.feature.auth.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import ru.rosystem.mobileedm.R
import ru.rosystem.mobileedm.common.ui.theme.DefaultBackgroundGradientEndColor
import ru.rosystem.mobileedm.common.ui.theme.DefaultBackgroundGradientStartColor
import ru.rosystem.mobileedm.common.ui.theme.Purple700

@Composable
internal fun AuthScreen(navController: NavController) {
    var progressState by remember {
        mutableStateOf(false)
    }
    AuthContent(progressState)
}


@Composable
private fun AuthContent(progressIsVisible: Boolean) {
    Column(
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
            .padding(16.dp)) {
        Box(
            Modifier
                .fillMaxSize()
                .weight(0.5f)) {
            Text(
                text = stringResource(id = R.string.common_enable_nfc),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                color = Purple700,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .align(Alignment.Center)
            )
        }

        Box(
            Modifier
                .fillMaxSize()
                .weight(0.5f)) {
            if (progressIsVisible) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(75.dp)
                        .align(Alignment.TopCenter)
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
private fun AuthScreenPreview() {
    AuthContent(false)
}