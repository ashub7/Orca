package com.orca.dashboard.navigation

import HomeScreen
import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.orca.dashboard.dashboard.DashBoardScreen


const val DashBoardScreenRoute = "dashboard"

fun NavController.navigateToDashBoard(navOptions: NavOptions? = null) = navigate(DashBoardScreenRoute, navOptions)

fun NavGraphBuilder.dashBoardNavigation() {
    navigation(
        route = "dashboard",
        startDestination = "home"
    ) {
        composable("home") { _ ->
            HomeScreen()
        }
        composable("search") { _ ->
            Text("Search Screen")
        }
        composable("account") { _ ->
            Text("Account Screen")
        }
    }
}
