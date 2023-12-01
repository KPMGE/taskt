package com.example.taskt.data

import kotlinx.serialization.Serializable

@Serializable
class TodoGroup (
    val id: Int,
    val title: String,
    val hexColor: String,
    val todos: List<Todo>,
)
