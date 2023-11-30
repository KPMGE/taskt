package com.example.taskt.ui.todo_group

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskt.data.Todo
import com.example.taskt.data.TodoGroup
import com.example.taskt.data.TodoGroupRepository
import com.example.taskt.ui.theme.Blue900
import kotlinx.coroutines.launch
import javax.inject.Inject

class TodoGroupViewModel @Inject constructor(
    private val todoGroupRepository: TodoGroupRepository
): ViewModel() {
    var _todoGroups = MutableLiveData<List<TodoGroup>>(emptyList())

    val todoGroups: LiveData<List<TodoGroup>> = _todoGroups

    init {
        viewModelScope.launch {
            val todoGroups = todoGroupRepository.getTodoGroups()
            this@TodoGroupViewModel._todoGroups.value = todoGroups
        }
    }
}