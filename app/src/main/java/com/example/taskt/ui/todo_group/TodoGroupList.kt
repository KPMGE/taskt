package com.example.taskt.ui.todo_group

import android.graphics.Color.parseColor
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.taskt.data.Todo
import com.example.taskt.data.TodoGroup
import com.example.taskt.ui.todo_list.TodosList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoGroupList(todoGroups: List<TodoGroup>, modifier: Modifier = Modifier) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }
    var bottomSheetColor by remember { mutableStateOf(Color.White) }
    var bottomSheetTodos by remember { mutableStateOf<List<Todo>>(emptyList()) }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState,
            modifier = Modifier.height(screenHeight.dp),
            containerColor = bottomSheetColor
        ) {
            TodosList(todos = bottomSheetTodos)
        }
    }

    LazyColumn (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 25.dp, top = 5.dp, bottom = 5.dp)
            .then(modifier)
    ) {
        itemsIndexed(todoGroups) { idx, group ->
            ElevatedCard(
                onClick = {
                    showBottomSheet = true
                    bottomSheetColor = Color(parseColor(group.hexColor))
                    bottomSheetTodos = group.todos
                },
                colors = CardDefaults.cardColors(
                    containerColor = Color(parseColor(group.hexColor))
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