package ru.rosystem.mobileedm.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.rosystem.mobileedm.common.ui.theme.MobileEDMTheme
import ru.rosystem.mobileedm.core.navigation.MainActivityNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MobileEDMTheme { MainActivityNavigation() } }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MobileEDMTheme { MainActivityNavigation() }
}