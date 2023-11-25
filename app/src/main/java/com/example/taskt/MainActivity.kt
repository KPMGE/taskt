package com.example.taskt

import androidx.compose.material3.Icon
import android.os.Bundle
import androidx.compose.foundation.layout.padding
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
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
import androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Offset
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.modifier.modifierLocalConsumer

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
                    HomeScreen()
                }
            }
        }
    }
}

class TodoGroup (
    val title: String,
    val color: Color,
    val todos: List<Todo>,
)

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeScreen() {
    var todos =  remember { mutableStateListOf<Todo>(
        Todo("Task 1", false, "desc 1"),
        Todo("Task 2", false, "desc 2"),
        Todo("Task 3", false, "desc 3"),
        Todo("Task 4", false, "desc 4")
    ) }

    var todoGroups = remember { mutableStateListOf<TodoGroup>(
        TodoGroup("Group 1", Color.Magenta, todos),
        TodoGroup("Group 2", Color.Blue, todos),
        TodoGroup("Group 3", Color.Green, todos),
        TodoGroup("Group 3", Color.Green, todos),
        TodoGroup("Group 3", Color.Green, todos),
        TodoGroup("Group 3", Color.Green, todos),
        TodoGroup("Group 3", Color.Green, todos),
        TodoGroup("Group 3", Color.Green, todos),
        TodoGroup("Group 3", Color.Green, todos),
    ) }

    fun addTodo() {
        todos.add(Todo("New Task", false, "New des"))
    }

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
            AddTodoButton(onClick = { addTodo() })
        }
    ) { innerPadding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            TodosList(todos = todos, modifier = Modifier.weight(0.6f))
            Divider(
                modifier = Modifier.size(height = 5.dp, width = 0.dp)
            )
            TodoGroupList(todoGroups = todoGroups, modifier = Modifier.weight(0.4f))
        }
    }
}

@Composable
fun TodosList(todos: List<Todo>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier
            .padding(10.dp)
            .then(modifier)
    ) {
        itemsIndexed(todos) { idx, todo ->
            TodoCard(
                todo = Todo(todo.title, false, "ksdjfa"),
                color = Color.Red)
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(1.dp),
                color = Color.LightGray
            )
        }
    }
}

@Composable
fun TodoGroupList(todoGroups: List<TodoGroup>, modifier: Modifier = Modifier) {
    LazyColumn (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp, top = 5.dp, bottom = 5.dp)
            .then(modifier)
    ) {
        itemsIndexed(todoGroups) { idx, group ->
            ElevatedCard(
                colors = CardDefaults.cardColors(
                    containerColor = group.color
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 4.dp, vertical = 5.dp)
            ) {
                Text(
                    modifier = Modifier.padding(15.dp),
                    text = group.title,
                    color = Color.White
                )
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
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            var checked = remember { mutableStateOf(false) }

            Checkbox(
                checked = checked.value,
                onCheckedChange = { checked.value = it }
            )
            Text(
                text = todo.title,
                textAlign = TextAlign.Center,
                color = Color.DarkGray
            )
        }
    }
}

@Composable
fun AddTodoButton(onClick: () -> Unit) {
    FloatingActionButton(
        containerColor = MaterialTheme.colorScheme.primary,
        onClick = { onClick() },
        shape = CircleShape,
    ) {
        Icon(Icons.Filled.Add, "Add todo button")
    }
}