package com.example.taskt.ui.todo_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.taskt.data.Todo

@Composable
fun TodoCard(todo: Todo) {
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
