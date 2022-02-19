package ru.rosystem.mobileedm.feature.registration.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import ru.rosystem.mobileedm.common.ui.theme.DefaultPrimaryColor
import ru.rosystem.mobileedm.common.utils.TextFieldData
import ru.rosystem.mobileedm.common.utils.getViewModel

@Composable
internal fun RegistrationScreen(
    navController: NavController,
    viewModel: RegistrationViewModel = getViewModel()
) {
    viewModel.run {
        RegistrationScreenContent(
            TextFieldData(
                emailState.value.value,
                emailState.isError.value
            ) { emailState.value.value = it },
            TextFieldData(
                passwordState.value.value,
                passwordState.isError.value,
                ::handlePassword
            ),
            TextFieldData(
                passwordRepeatState.value.value,
                passwordRepeatState.isError.value,
                ::handlePasswordRepeat
            ),
            viewModel.showSnackBarError.value
        ) { process() }

        LaunchedEffect(key1 = viewModel.showSnackBarError.value) {
            if (viewModel.showSnackBarError.value) {
                delay(2000)
                viewModel.showSnackBarError.value = false
            }
        }
    }
}

@Composable
private fun RegistrationScreenContent(
    email: TextFieldData,
    password: TextFieldData,
    passwordRepeat: TextFieldData,
    showErrorToast: Boolean,
    processCallback: () -> Unit
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        if (showErrorToast) {
            Snackbar(modifier = Modifier.align(Alignment.TopCenter)) {
                Text(text = "Пароли не совпадают", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
            }
        }
        Column {
            OutlinedTextField(
                value = email.value,
                onValueChange = email.onValueChange,
                singleLine = true,
                label = { Text("Email") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = DefaultPrimaryColor,
                    focusedLabelColor = DefaultPrimaryColor
                ),
                isError = email.isError,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(top = 48.dp, bottom = 24.dp)
            )
            OutlinedTextField(
                value = password.value, onValueChange = password.onValueChange, singleLine = true,
                label = { Text("Пароль") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = DefaultPrimaryColor,
                    focusedLabelColor = DefaultPrimaryColor
                ),
                isError = password.isError,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )
            OutlinedTextField(
                value = passwordRepeat.value,
                onValueChange = passwordRepeat.onValueChange,
                label = { Text("Повторите пароль") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = DefaultPrimaryColor,
                    focusedLabelColor = DefaultPrimaryColor
                ),
                isError = passwordRepeat.isError,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )

            Button(
                onClick = { processCallback() },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 24.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = "Зарегистрироваться")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun RegistrationScreenContentPreview() {
    RegistrationScreenContent(
        TextFieldData("", false, {}),
        TextFieldData("", false, {}),
        TextFieldData("", false, {}),
        true,
        {}
    )
}