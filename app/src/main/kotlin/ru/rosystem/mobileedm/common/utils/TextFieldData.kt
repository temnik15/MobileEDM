package ru.rosystem.mobileedm.common.utils

import androidx.compose.runtime.MutableState


data class TextFieldState(val value: MutableState<String>, val isError: MutableState<Boolean>)
data class TextFieldData(
    val value: String,
    val isError: Boolean = false,
    val onValueChange: (String) -> Unit
)