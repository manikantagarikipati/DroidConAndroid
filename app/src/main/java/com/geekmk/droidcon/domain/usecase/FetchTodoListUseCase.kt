package com.geekmk.droidcon.domain.usecase

import com.geekmk.droidcon.data.model.TodoDataItem
import com.geekmk.droidcon.data.repository.TodoListRepository
import javax.inject.Inject

interface FetchTodoListUseCase {
    fun execute(): List<TodoDataItem>
}

class FetchTodoListUseCaseImpl @Inject constructor(val repository: TodoListRepository) : FetchTodoListUseCase {
    override fun execute(): List<TodoDataItem> {
        return emptyList()
    }
}