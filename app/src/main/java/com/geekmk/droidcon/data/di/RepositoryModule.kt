package com.geekmk.droidcon.data.di

import com.geekmk.droidcon.data.repository.TodoListRepository
import com.geekmk.droidcon.data.repository.TodoListRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import java.util.*
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {
    @Binds
    fun provideTodoRepository(todoListRepositoryImpl: TodoListRepositoryImpl): TodoListRepository
}
