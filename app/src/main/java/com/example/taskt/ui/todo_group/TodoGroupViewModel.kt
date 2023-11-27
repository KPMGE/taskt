package com.example.taskt.ui.todo_group

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.taskt.data.TodoGroup
import com.example.taskt.ui.theme.Blue900

class TodoGroupViewModel(): ViewModel() {
    var todoGroups = MutableLiveData<List<TodoGroup>>(
        listOf(
            TodoGroup("Group 1", Blue900, emptyList()),
            TodoGroup("Group 2", Color.Magenta, emptyList()),
            TodoGroup("Group 3", Color.Cyan, emptyList()),
            TodoGroup("Group 3", Color.Green, emptyList()),
        )
    )
}