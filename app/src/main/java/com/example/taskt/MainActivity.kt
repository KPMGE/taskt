package com.example.taskt

import android.os.Bundle
import androidx.compose.foundation.layout.padding
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskt.ui.theme.TasktTheme

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
                    class TodoConf (
                        val title: String,
                        val color: Color
                    )

                    val arr = arrayOf(
                        TodoConf("Task 1", Color.Red),
                        TodoConf("Task 2", Color.Blue),
                        TodoConf("Task 3", Color.Magenta),
                        TodoConf("Task 4", Color.Yellow)
                    )

                    Column(
                        modifier = Modifier.padding(10.dp),
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