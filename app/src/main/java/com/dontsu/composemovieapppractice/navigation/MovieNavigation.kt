package com.dontsu.composemovieapppractice.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.dontsu.composemovieapppractice.model.Movie
import com.dontsu.composemovieapppractice.screens.details.DetailsScreen
import com.dontsu.composemovieapppractice.screens.home.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {
        composable(MovieScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }

        // 마치 웹에 path가 www.google.com/login/id=34 처럼 되어있는것을 argument를 보낼 때도 똑같이 전달한다고 생각하면 된다
        composable(
            MovieScreens.DetailsScreen.name + "/{movie}",
            arguments = listOf(
                navArgument(name = "movie") {
                    type = MovieNavType()
                }
            )
        ) { backStackEntry ->
            DetailsScreen(
                navController = navController,
                backStackEntry.arguments?.getParcelable<Movie>("movie")!!
            )
        }

    }

}
