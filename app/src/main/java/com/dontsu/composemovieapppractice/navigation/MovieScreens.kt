package com.dontsu.composemovieapppractice.navigation

// enum class로 관리하기

//substringBefore 사용
// ex) www.google.com/sign_in 있을 때 sign_in을 가져옴

enum class MovieScreens {
    HomeScreen,
    DetailsScreen;

    companion object {
        fun fromRoute(route: String?): MovieScreens = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }

}
