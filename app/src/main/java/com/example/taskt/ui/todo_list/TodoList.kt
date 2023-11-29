package com.example.taskt.ui.todo_list

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.taskt.data.Todo

@Composable
fun TodosList(todos: List<Todo>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier
            .padding(10.dp)
            .then(modifier)
    ) {
        itemsIndexed(todos) { idx, todo ->
            TodoCard(
                Todo(
                    todo.id,
                    todo.title,
                    todo.done,
                    todo.description,
                    todo.hexColor
                )
            )
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(1.dp),
                color = Color.LightGray
            )
        }
    }
}
