package com.example.taskt.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TodoRepositoryImpl : TodoRepository {
    private var todos = mutableListOf(
        Todo("Task 1", false, "desc 1"),
        Todo("Task 2", false, "desc 2"),
        Todo("Task 3", false, "desc 3"),
        Todo("Task 4", false, "desc 4")
    )
    override fun addTodo(todo: Todo) {
        this.todos.add(todo)
    }
    override fun getTodos(): Flow<List<Todo>> = flow {
        emit(todos)
    }
}
