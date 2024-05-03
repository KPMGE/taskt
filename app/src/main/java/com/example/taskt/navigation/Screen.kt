package com.example.taskt.navigation

sealed class Screen(val route: String) {
    object Home: Screen("Home")
    object CreateTodo: Screen("Create Todo")
}