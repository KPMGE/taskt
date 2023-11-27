package com.example.taskt.di
import com.example.taskt.data.TodoRepository
import com.example.taskt.data.TodoRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideTodoRepository(): TodoRepository {
        return TodoRepositoryImpl()
    }
}