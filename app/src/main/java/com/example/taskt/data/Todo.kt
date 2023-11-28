package com.example.taskt.data

import kotlinx.serialization.Serializable

@Serializable
class Todo (
    val id: Int,
    val title: String,
    val done: Boolean = false,
    val description: String?
)