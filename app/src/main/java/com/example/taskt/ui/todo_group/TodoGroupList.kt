package com.example.taskt.ui.todo_group

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.taskt.data.TodoGroup

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