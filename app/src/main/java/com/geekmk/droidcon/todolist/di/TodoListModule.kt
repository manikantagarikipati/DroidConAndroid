package com.geekmk.droidcon.todolist.di

import com.geekmk.droidcon.todolist.adapter.TodoListAdapter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
interface TodoListModule {
    @Binds
    fun bindTodoListAdapter(todoListAdapter: TodoListAdapter): TodoListAdapter
}
