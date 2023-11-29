package com.example.taskt.data

import android.util.Log
import com.example.taskt.common.ApiClient
import com.example.taskt.common.ApiRoutes
import io.ktor.client.call.body
import io.ktor.client.request.get

class TodoRepositoryImpl : TodoRepository {
    override suspend fun addTodo(todo: Todo) {
        Log.d("UNIMPLEMENTED", "addTodo")
    }
    override suspend fun getTodos(): List<Todo> {
        val todos = ApiClient.client.get(ApiRoutes.ALL_TODOS).body<List<Todo>>()
        return todos
    }
}
