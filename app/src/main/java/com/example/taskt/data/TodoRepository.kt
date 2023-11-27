package com.example.taskt.data

import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun getTodos(): Flow<List<Todo>>
    fun addTodo(todo: Todo)
}
