package com.example.taskt.ui.todo_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccessTime
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskt.data.TodoGroup
import com.example.taskt.ui.theme.Blue900
import com.example.taskt.ui.theme.TasktTheme
import com.example.taskt.ui.todo_group.TodoGroupList

@Composable
fun CreateTodoScreen() {
    val fakeTodoGroups = listOf(
        TodoGroup(1, "Group 1", "#0000FF", emptyList()),
        TodoGroup(2, "Group 2", "#e30b5c", emptyList()),
        TodoGroup(3, "Group 3", "#fc440f", emptyList()),
        TodoGroup(1, "Group 1", "#0000FF", emptyList()),
        TodoGroup(2, "Group 2", "#e30b5c", emptyList()),
        TodoGroup(3, "Group 3", "#fc440f", emptyList()),
        TodoGroup(1, "Group 1", "#0000FF", emptyList()),
        TodoGroup(2, "Group 2", "#e30b5c", emptyList()),
        TodoGroup(3, "Group 3", "#fc440f", emptyList()),
    )

    var text by remember { mutableStateOf("") }
    var isDatePickerSelected by remember { mutableStateOf(false) }
    var isTimePickerSelected by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { TopBar() },
        bottomBar = {
            BottomBar(
                todoGroups = fakeTodoGroups,
                isDatePickerSelected = isDatePickerSelected,
                isTimePickerSelected = isTimePickerSelected,
                onDatePickerClick = { isDatePickerSelected = !isDatePickerSelected },
                onTimePickerClick = { isTimePickerSelected = !isTimePickerSelected }
            )

        }
    ) { padding ->
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(10.dp),
        ) {
            TodoInput(text = text, onValueChange = { text = it })
        }
    }
}

@Composable
private fun TopBar() {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "cancel", color = Color(0xFFC70039))
        Text(text = "done", color = Color(0xFF0096FF))
    }
}

@Composable
private fun TodoInput(text: String, onValueChange: (String) -> Unit) {
    TextField(
        value = text,
        onValueChange = onValueChange,
        label = { Text(text = "I need to...") },
        modifier = Modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.DarkGray,
            disabledTextColor = Color.Transparent,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            disabledContainerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        )
    )
}

@Composable
private fun BottomBar(
    modifier: Modifier = Modifier,
    todoGroups: List<TodoGroup>,
    isDatePickerSelected: Boolean,
    isTimePickerSelected: Boolean,
    onDatePickerClick: () -> Unit,
    onTimePickerClick: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth().height(350.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onDatePickerClick) {
                    Icon(
                        Icons.Rounded.DateRange,
                        contentDescription = "date picker icon",
                        tint = if (isDatePickerSelected) Blue900 else Color.LightGray
                    )
                }
                Spacer(modifier = Modifier.width(30.dp))
                IconButton(onClick = onTimePickerClick) {
                    Icon(
                        Icons.Rounded.AccessTime,
                        contentDescription = "time pick icon",
                        tint = if (isTimePickerSelected) Blue900 else Color.LightGray
                    )
                }
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Group 1", color = Blue900)
                Spacer(modifier = Modifier.width(3.dp))
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(Color(android.graphics.Color.parseColor("#0000FF")))
                )
            }
        }
        TodoGroupList(todoGroups)
    }
}

@Preview(showBackground = true)
@Composable
private fun CreateTodoScreenPreview() {
    TasktTheme {
        CreateTodoScreen()
    }
}