package com.ammar.ishfaq.drugs.navigation

import HomeScreen
import LoginApp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.ammar.ishfaq.drugs.ui.home.HomeViewModel
import com.ammar.ishfaq.drugs.utility.Constants

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = TopLevelDestination.Login.route
    ) {


        composable(route = TopLevelDestination.Login.route) {
            LoginApp { userName ->
                navController.navigate(TopLevelDestination.Home.withArgs(userName))

            }
        }
        composable(route = TopLevelDestination.Home.route + "/{${Constants.USERNAME}}",
            arguments = listOf(
                navArgument(Constants.USERNAME) {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val username =
                backStackEntry.arguments?.getString(Constants.USERNAME) ?: return@composable
            val homeViewModel: HomeViewModel = hiltViewModel()
            val homeScreenUiState by remember { homeViewModel.response }.collectAsStateWithLifecycle()

            HomeScreen(
                username,
                uiState = homeScreenUiState,
                loadData = { homeViewModel.loadData(it) },
                onRefresh = { homeViewModel.loadData(true) }
            )
        }

    }
}
