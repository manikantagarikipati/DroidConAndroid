package com.geekmk.droidcon.data.repository

interface TodoListRepository {
    fun getListItems()

    fun addTodoItem()
}

class TodoListRepositoryImpl:TodoListRepository{
    override fun getListItems() {
        TODO("Not yet implemented")
    }

    override fun addTodoItem() {
        TODO("Not yet implemented")
    }

}