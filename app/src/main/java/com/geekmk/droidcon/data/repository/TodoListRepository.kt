package com.geekmk.droidcon.data.repository

import com.geekmk.droidcon.data.local.Todo
import com.geekmk.droidcon.data.local.TodoDao
import com.geekmk.droidcon.data.model.TodoDataItem
import com.geekmk.droidcon.data.utils.TimeUtil
import java.util.*
import javax.inject.Inject

interface TodoListRepository {
    fun getListItems(): List<TodoDataItem>

    fun addTodoItem(title: String): TodoDataItem
}

class TodoListRepositoryImpl @Inject constructor(
        private val timeUtil: TimeUtil,
        private val dao: TodoDao) : TodoListRepository {

    override fun getListItems(): List<TodoDataItem> {
        return dao.getAll().map {
            TodoDataItem(it.title,it.createdTime)
        }
    }

    override fun addTodoItem(title: String): TodoDataItem {
        val insertedId = dao.insert(Todo(id = 0, title = title, createdTime = timeUtil.getTimeNow()))
        return dao.loadSingle(insertedId).let {
            TodoDataItem(it.title,it.createdTime)
        }
    }
}