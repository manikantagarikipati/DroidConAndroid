package com.geekmk.droidcon.data.remote

import com.geekmk.droidcon.data.model.TodoDataItem
import retrofit2.http.GET
import retrofit2.http.POST


interface TodoApiService {

    @GET("/todo/")
    fun getTodoItems():List<TodoDataItem>

    @POST("/todo/")
    fun addTodoItem(todoDataItem: TodoDataItem)
}