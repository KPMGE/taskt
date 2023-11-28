package com.example.taskt.data

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.accept
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

object ApiRoutes {
    private const val BASE_URL:String = "http://10.0.2.2:3000"
    var TODOS = "$BASE_URL/todos.json"
}

object ApiClient {

    //Configure the HttpCLient
    @OptIn(ExperimentalSerializationApi::class)
    var client = HttpClient(Android) {

        // For Logging
        install(Logging) {
            level = LogLevel.ALL
        }

        // Timeout plugin
        install(HttpTimeout) {
            requestTimeoutMillis = 15000L
            connectTimeoutMillis = 15000L
            socketTimeoutMillis = 15000L
        }

        // JSON Response properties
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                    prettyPrint = true
                    isLenient = true
                    explicitNulls = false
                }
            )
        }

        // Default request for POST, PUT, DELETE,etc...
        install(DefaultRequest) {
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            //add this accept() for accept Json Body or Raw Json as Request Body
            accept(ContentType.Application.Json)
        }

    }
}
class TodoRepositoryImpl : TodoRepository {
    override suspend fun addTodo(todo: Todo) {
        Log.d("UNIMPLEMENTED", "addTodo")
    }
    override suspend fun getTodos(): List<Todo> {
        val todos = ApiClient.client.get(ApiRoutes.TODOS).body<List<Todo>>()
        return todos
    }
}
