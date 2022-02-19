package ru.rosystem.mobileedm.feature.registration.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import ru.rosystem.mobileedm.common.utils.TextFieldState


internal class RegistrationViewModel : ViewModel() {

    val emailState = TextFieldState(
        mutableStateOf(""),
        mutableStateOf(false)
    )
    val passwordState = TextFieldState(
        mutableStateOf(""),
        mutableStateOf(false)
    )
    val passwordRepeatState = TextFieldState(
        mutableStateOf(""),
        mutableStateOf(false)
    )

    var showSnackBarError = mutableStateOf(false)

    fun handlePassword(value: String) {
        passwordState.value.value = value
        setPasswordErrorEnabled(false)
    }

    fun handlePasswordRepeat(value: String) {
        passwordRepeatState.value.value = value
        setPasswordErrorEnabled(false)
    }

    fun process() {
        if (passwordState.value != passwordRepeatState.value) {
            setPasswordErrorEnabled(true)
        }
    }


    private fun setPasswordErrorEnabled(enabled: Boolean) {
        if (enabled) showSnackBarError.value = true
        passwordState.isError.value = enabled
        passwordRepeatState.isError.value = enabled
    }
}