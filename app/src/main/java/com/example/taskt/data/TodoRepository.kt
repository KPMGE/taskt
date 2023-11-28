package com.example.taskt.data

interface TodoRepository {
    suspend fun getTodos(): List<Todo>
    suspend fun addTodo(todo: Todo)
}
