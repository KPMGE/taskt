package com.example.taskt.ui.todo_list

import androidx.lifecycle.ViewModel
import com.example.taskt.data.Todo
import com.example.taskt.data.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
    private val todoRepository: TodoRepository
): ViewModel() {
    var todos = this.todoRepository.getTodos()

    /*
    init {
        viewModelScope.launch {
            val todos = todoRepository.getTodos()
            this@TodoListViewModel.todos.value = todos
            this@TodoListViewModel.todos2
        }
    }
    */
    fun addTodo(newTodo: Todo) {
        this.todoRepository.addTodo(newTodo)
    }
}