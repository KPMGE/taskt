package com.example.taskt.data

import android.util.Log
import com.example.taskt.common.ApiClient
import com.example.taskt.common.ApiRoutes
import io.ktor.client.call.body
import io.ktor.client.request.get

class TodoGroupRepositoryImpl: TodoGroupRepository {
    override suspend fun addTodoGroup(todoGroup: TodoGroup) {
        Log.d("UNIMPLEMENTED", "addTodoGroup")
    }
    override suspend fun getTodoGroups(): List<TodoGroup>  = ApiClient.client.get(ApiRoutes.ALL_TODO_GROUPS).body()
}