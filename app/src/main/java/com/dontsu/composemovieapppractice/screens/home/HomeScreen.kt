package com.dontsu.composemovieapppractice.screens.home

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.dontsu.composemovieapppractice.model.Movie
import com.dontsu.composemovieapppractice.model.getMovies
import com.dontsu.composemovieapppractice.navigation.MovieScreens
import com.dontsu.composemovieapppractice.widgets.MovieRow
import com.google.gson.Gson

@Composable
fun HomeScreen(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                elevation = 5.dp
            ) {
                Text(text = "Movies", color = Color.Black, style = MaterialTheme.typography.h5)
            }
        }
    ) {
        MainContent(navController = navController)
    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()) {
    Column(
        modifier = Modifier.padding(12.dp)
    ) {
        LazyColumn {
            items(items = movieList) { movie ->
                MovieRow(movie = movie) {
                    val movieToJson = Uri.encode(Gson().toJson(movie))
                    navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movieToJson")
                }
            }
        }
    }
}
