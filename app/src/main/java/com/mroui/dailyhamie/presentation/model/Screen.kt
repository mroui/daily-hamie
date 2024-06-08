package com.mroui.dailyhamie.presentation.model

internal sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Quiz : Screen("quiz")
    object Result : Screen("result")
}
