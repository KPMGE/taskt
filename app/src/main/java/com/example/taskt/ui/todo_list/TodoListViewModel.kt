package com.example.taskt.ui.todo_list
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.taskt.data.Todo

class TodoListViewModel(): ViewModel() {
    var todos = MutableLiveData<List<Todo>>(
        mutableListOf(
            Todo("Task 1", false, "desc 1"),
            Todo("Task 2", false, "desc 2"),
            Todo("Task 3", false, "desc 3"),
            Todo("Task 4", false, "desc 4")
        )
    )
}