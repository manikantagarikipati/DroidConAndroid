package com.geekmk.droidcon.domain.usecase

import com.geekmk.droidcon.data.model.TodoDataItem
import com.geekmk.droidcon.data.repository.TodoListRepository
import javax.inject.Inject

interface AddTodoListItemUseCase {
    fun execute(title: String):TodoDataItem
}

class AddTodoListItemUseCaseImpl @Inject constructor(val repository: TodoListRepository):AddTodoListItemUseCase{
    override fun execute(title: String):TodoDataItem {
        return repository.addTodoItem(title)
    }
}