package com.example.taskt

import androidx.compose.material3.Icon
import android.os.Bundle
import androidx.compose.foundation.layout.padding
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskt.ui.theme.TasktTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TasktTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold (
                        topBar = {
                            TopAppBar(
                                colors = mediumTopAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.background,
                                    titleContentColor = Color.DarkGray,
                                ),
                                title = {
                                    Text("Today Tasks")
                                }
                            )
                        },
                        floatingActionButton = {
                            AddTodoButton()
                        }
                    ) { innerPadding ->
                        class TodoConf(
                            val title: String,
                            val color: Color
                        )

                        val arr = arrayOf(
                            TodoConf("Task 1", Color(0xff006064)),
                            TodoConf("Task 2", Color(0xffb388ff)),
                            TodoConf("Task 3", Color(0xff3f51b5)),
                            TodoConf("Task 4", Color(0xff880e4f))
                        )

                        Column(
                            modifier = Modifier.padding(innerPadding).padding(5.dp),
                        ) {
                            arr.forEach { elem ->
                                TodoCard(
                                    todo = Todo(elem.title, false, "ksdjfa"),
                                    color = elem.color)
                                Box(modifier = Modifier.size(width = 0.dp, height = 10.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}



class Todo (
    val title: String,
    val done: Boolean = false,
    val description: String,
)

@Composable
fun TodoCard(todo: Todo, color: Color) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = color
        ),
        modifier = Modifier.fillMaxWidth()

    ) {
        Text(
            text = todo.title,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Center,
            color = Color.White

        )
    }
}

@Composable
fun AddTodoButton() {
    FloatingActionButton(
        containerColor = MaterialTheme.colorScheme.primary,
        onClick = { println("Button Clicked") },
        shape = CircleShape,
    ) {
        Icon(Icons.Filled.Add, "Add todo button")
    }
}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TasktTheme {
        Greeting("Android")
    }
}