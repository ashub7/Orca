
package com.orca.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.orca.auth.login.navigation.LoginRoute
import com.orca.auth.login.navigation.loginScreen
import com.orca.dashboard.navigation.DashBoardScreenRoute
import com.orca.dashboard.navigation.dashBoardNavigation

@Composable
fun AppNavHost(
    appState: MainAppState,
    onShowSnackBar: suspend (String, String?) -> Boolean,
    modifier: Modifier = Modifier,
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = LoginRoute,
        modifier = modifier,
    ) {
        loginScreen{
            navController.navigate(DashBoardScreenRoute)
        }
        dashBoardNavigation()

    }
}
