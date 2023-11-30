package com.example.taskt.data
interface TodoGroupRepository {
    suspend fun getTodoGroups(): List<TodoGroup>
    suspend fun addTodoGroup(todoGroup: TodoGroup)
}