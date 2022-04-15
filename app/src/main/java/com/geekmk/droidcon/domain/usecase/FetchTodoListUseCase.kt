package com.geekmk.droidcon.domain.usecase

import com.geekmk.droidcon.data.model.TodoDataItem
import com.geekmk.droidcon.data.repository.TodoListRepository
import java.util.*
import javax.inject.Inject

interface FetchTodoListUseCase {
    fun execute(): List<TodoDataItem>
}

class FetchTodoListUseCaseImpl @Inject constructor(private val repository: TodoListRepository) : FetchTodoListUseCase {
    override fun execute(): List<TodoDataItem> {
        return repository.getListItems()
    }
}
