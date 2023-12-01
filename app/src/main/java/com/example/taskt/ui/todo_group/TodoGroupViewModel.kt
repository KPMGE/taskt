package com.example.taskt.ui.todo_group

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskt.data.TodoGroup
import com.example.taskt.data.TodoGroupRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

internal inline fun <reified R : Any> String.convertToDataClass() = Json {
        ignoreUnknownKeys = true
    }.decodeFromString<R>(this)

@HiltViewModel
class TodoGroupViewModel @Inject constructor(
    private val todoGroupRepository: TodoGroupRepository
): ViewModel() {
    var _todoGroups = MutableLiveData<List<TodoGroup>>(emptyList())

    val todoGroups: LiveData<List<TodoGroup>> = _todoGroups
    init {
        viewModelScope.launch {
            try {
                val todoGroups = todoGroupRepository.getTodoGroups()
                this@TodoGroupViewModel._todoGroups.value = todoGroups
            } catch (e: Exception) {
                Log.d("ERROR", e.message.toString())
                this@TodoGroupViewModel._todoGroups.value = emptyList()
            }
        }
    }
}