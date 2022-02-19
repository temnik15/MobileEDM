package ru.rosystem.mobileedm.feature.registration.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import ru.rosystem.mobileedm.common.ui.theme.DefaultPrimaryColor
import ru.rosystem.mobileedm.feature.registration.ui.component.Dot
import ru.rosystem.mobileedm.feature.registration.ui.component.DotState

@Composable
internal fun CreatePinCodeScreen() {
    CreatePinCodeScreenContent()
}

@Composable
private fun CreatePinCodeScreenContent() {
    Column(Modifier.fillMaxSize()) {
        Text(
            text = "Придумайте код-пароль:",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 120.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = DefaultPrimaryColor,
            fontSize = 20.sp
        )
        val listener = PinCode(
            Modifier
                .align(Alignment.CenterHorizontally)
                .padding(25.dp),
            showErrorEvent = false
        )
        Keyboard()
    }

}


@Composable
@Preview(showBackground = true)
private fun CreatePinCodeScreenContentPreview() {
    CreatePinCodeScreenContent()
}

@Composable
internal fun PinCode(modifier: Modifier = Modifier, showErrorEvent: Boolean): (Int) -> Unit {
    var countActiveDots by remember {
        mutableStateOf(0)
    }

    var showErrorState by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = showErrorEvent) {
        if (showErrorEvent) {
            showErrorState = true
            delay(2000)
            showErrorState = false
        }
    }
    PinCodeContent(modifier, countActiveDots = countActiveDots, showError = showErrorState)
    return { countActiveDots = it }
}

@Composable
private fun PinCodeContent(modifier: Modifier, countActiveDots: Int, showError: Boolean = false) {
    Row(modifier) {
        repeat(4) {
            Dot(
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 6.dp),
                state = when {
                    showError -> DotState.ERROR
                    countActiveDots > it -> DotState.ACTIVE
                    else -> DotState.DEFAULT
                }
            )
        }
    }
}

@Composable
internal fun Keyboard() {
    KeyboardContent()
}

@Composable
private fun KeyboardContent() {
    Column() {
        var number = 1
        repeat(3) {
            Row() {
                repeat(3) {
                    OutlinedButton(onClick = { /*TODO*/ }) {
                        Text(text = "$number")
                        number++
                    }
                }
            }
        }
    }
}

