package ru.rosystem.mobileedm.feature.registration.ui.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.rosystem.mobileedm.R
import ru.rosystem.mobileedm.common.ui.theme.ColorLightGray
import ru.rosystem.mobileedm.common.ui.theme.DefaultPrimaryColor

enum class DotState {
    DEFAULT,
    ACTIVE,
    ERROR
}

@Composable
internal fun Dot(modifier: Modifier = Modifier, state: DotState) {
    var color by remember {
        mutableStateOf(DefaultPrimaryColor)
    }
    val animatedColor by animateColorAsState(
        targetValue = color,
        animationSpec = spring(dampingRatio = Spring.DampingRatioHighBouncy)
    )

    LaunchedEffect(key1 = state) {
        color = when (state) {
            DotState.DEFAULT -> ColorLightGray
            DotState.ACTIVE -> DefaultPrimaryColor
            DotState.ERROR -> Color.Red
        }
    }
    DotContent(modifier = modifier, color = animatedColor)
}

@Composable
private fun DotContent(modifier: Modifier = Modifier, color: Color) {
    Image(
        painter = painterResource(id = R.drawable.icons8_white_circle_96),
        contentDescription = "",
        modifier = modifier.size(24.dp),
        colorFilter = ColorFilter.tint(color)
    )
}

@Composable
@Preview
private fun DotContentPreview() {
    DotContent(Modifier,Color.Red)
}