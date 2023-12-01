package com.example.taskt

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.taskt.ui.HomeScreen
import com.example.taskt.ui.theme.TasktTheme
import com.example.taskt.ui.todo_list.CreateTodoScreen
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TasktTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    fun navigateToCreateTodo() {
                        navController.navigate("Create Todo")
                    }

                    NavHost(navController = navController, startDestination = "Home"){
                        composable("Home"){
                            HomeScreen(onNavigateCreateTodo = { navigateToCreateTodo() })
                        }
                        composable("Create Todo"){
                            CreateTodoScreen()
                        }
                    }
                }
            }
        }
    }
}