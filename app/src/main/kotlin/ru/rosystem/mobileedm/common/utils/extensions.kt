package ru.rosystem.mobileedm.common.utils

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavOptionsBuilder

/** @SelfDocumented */
@Composable
internal inline fun <reified T : ViewModel> getViewModel(factory: ViewModelProvider.Factory? = null): T =
    viewModel(factory = factory)

/**
 * Очистить стек навигации перед переходом на следующий экран.
 */
fun NavOptionsBuilder.clearDestination() = popUpTo(0)