package com.geekmk.droidcon.data.di

import com.geekmk.droidcon.data.repository.TodoListRepository
import com.geekmk.droidcon.data.repository.TodoListRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideTodoRepository(todoListRepositoryImpl: TodoListRepositoryImpl): TodoListRepository
}