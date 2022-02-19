package ru.rosystem.mobileedm.core.screen.load_dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
internal fun LoadDialog(onDismiss: () -> Unit, onLoad: () -> Unit) {
    LoadDialogScreenContent(onDismiss, onLoad)
}

@Composable
private fun LoadDialogScreenContent(onDismiss: () -> Unit, onLoad: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(12.dp)
        ) {
            Text(
                text = "Для корректной работы необходимо установить Rutoken service",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Row(modifier = Modifier.fillMaxWidth()) {
                TextButton(onClick = onDismiss) {
                    Text(text = "Выход")
                }
                Spacer(modifier = Modifier.weight(1f))
                TextButton(onClick = onLoad) {
                    Text(text = "Установить")
                }
            }
        }
    }
}