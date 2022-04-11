package com.geekmk.droidcon.data.repository

import com.geekmk.droidcon.data.model.TodoDataItem
import javax.inject.Inject

interface TodoListRepository {
    fun getListItems(): List<TodoDataItem>

    fun addTodoItem(todoDataItem: TodoDataItem)
}

class TodoListRepositoryImpl @Inject constructor() : TodoListRepository {
    override fun getListItems(): List<TodoDataItem> {
        return emptyList()
    }

    override fun addTodoItem(todoDataItem: TodoDataItem) {
        TODO("Not yet implemented")
    }
}