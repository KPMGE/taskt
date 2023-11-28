package com.example.taskt.ui

import com.example.taskt.ui.todo_list.TodoListViewModel

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.List
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.taskt.ui.theme.Blue900
import com.example.taskt.ui.todo_group.TodoGroupList
import com.example.taskt.ui.todo_group.TodoGroupViewModel
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.compose.runtime.collectAsState
import com.example.taskt.data.Todo
import com.example.taskt.ui.todo_list.TodosList

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeScreen(
    todosListViewModel: TodoListViewModel = hiltViewModel(),
    todoGroupsViewModel: TodoGroupViewModel = viewModel()
) {
    val todos = todosListViewModel.todos.observeAsState().value!!
    var todoGroups = todoGroupsViewModel.todoGroups.observeAsState().value!!

    var shouldOpenCreateModal = remember { mutableStateOf(false) }

    fun openCreateTodoModal() {
        shouldOpenCreateModal.value = true
    }

    fun closeCreateTodoModal() {
        shouldOpenCreateModal.value = false
    }

    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = Color.DarkGray,
                ),
                title = {
                    Text("Today Tasks")
                }
            )
        },
        floatingActionButton = {
            AddTodoButton(onClick = {
                openCreateTodoModal()
                todosListViewModel.addTodo(Todo(1, "TESTE TODO", false, "sdkjfa"))
            })
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
            Text(
                text = "Groups",
                fontSize = 24.sp,
                modifier = Modifier.padding(start = 27.dp),
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray
            )
            TodoGroupList(todoGroups = todoGroups, modifier = Modifier.weight(0.4f))
            if (shouldOpenCreateModal.value) {
                AddTodoOrGroupModal(onDismissRequest = { closeCreateTodoModal() })
            }
        }
    }
}
@Composable
fun AddTodoOrGroupModal(onDismissRequest: () -> Unit) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val cardHeight = 150
    val marginBottom = 100
    val marginLeft = 50

    Dialog(
        onDismissRequest = { onDismissRequest() },
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .offset(
                    x = marginLeft.dp,
                    y = (screenHeight - (cardHeight + marginBottom)).dp
                )
        ) {
            Card(
                modifier = Modifier
                    .height(cardHeight.dp)
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp),
            ) {
                Column (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                ) {
                    Row(
                        modifier = Modifier.weight(0.5f),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.List,
                            contentDescription = "group icon",
                            tint = Blue900
                        )
                        Text(
                            text = "Group",
                            color = Blue900,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(1.dp)
                    )
                    Row(
                        modifier = Modifier.weight(0.5f),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Check,
                            contentDescription = "list icon",
                            tint = Blue900
                        )
                        Text(
                            text = "Task",
                            color = Blue900,
                            modifier = Modifier.padding(start = 10.dp)
                        )
                    }
                }
            }
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
