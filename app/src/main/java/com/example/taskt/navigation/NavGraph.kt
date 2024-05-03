package com.example.taskt.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.taskt.ui.HomeScreen
import com.example.taskt.ui.todo_list.CreateTodoScreen

@Composable
fun NavHost(
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination = Screen.Home.route){
        composable(Screen.Home.route){
            HomeScreen(onNavigateCreateTodo = {
                navController.navigate(Screen.CreateTodo.route)
            })
        }
        composable(Screen.CreateTodo.route){
            CreateTodoScreen()
        }
    }
}