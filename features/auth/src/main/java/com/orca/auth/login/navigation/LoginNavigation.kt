package com.orca.auth.login.navigation

import LoginScreen
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable


const val LoginRoute = "login_route"

fun NavController.navigateToLoginScreen(navOptions: NavOptions? = null) = navigate(LoginRoute, navOptions)

fun NavGraphBuilder.loginScreen(
    onLoginSuccess: () -> Unit,
) {
    composable(route = LoginRoute) {
        LoginScreen(onLoginSuccess)
    }
}
