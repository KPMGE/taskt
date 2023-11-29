package com.example.taskt.data

import androidx.compose.ui.graphics.Color
import kotlinx.serialization.Serializable

@Serializable
class Todo (
    val id: Int,
    val title: String,
    val done: Boolean = false,
    val description: String?,
    val hexColor: String
)