package com.example.taskt.ui.todo_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskt.data.Todo
import com.example.taskt.data.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val todoRepository: TodoRepository
): ViewModel() {
    var _todos = MutableLiveData<List<Todo>>(emptyList())

    var todos: LiveData<List<Todo>> = _todos

    init {
        viewModelScope.launch {
            val todos = todoRepository.getTodos()
            this@TodoListViewModel._todos.value = todos
        }
    }
    fun addTodo(newTodo: Todo) {
        viewModelScope.launch {
            this@TodoListViewModel.todoRepository.addTodo(newTodo)
        }
    }
}