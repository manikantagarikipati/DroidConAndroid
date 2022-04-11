package com.geekmk.droidcon.todolist

import androidx.lifecycle.ViewModel
import com.geekmk.droidcon.domain.usecase.AddTodoListItemUseCase
import com.geekmk.droidcon.domain.usecase.FetchTodoListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
        private val fetchTodoListUseCase: FetchTodoListUseCase,
        private val addTodoListItemUseCase: AddTodoListItemUseCase
) : ViewModel() {

    fun fetchTodoList() {
        fetchTodoListUseCase.execute()
    }

    fun addTodoItem() {
        addTodoListItemUseCase.execute(title = "DroidConf Info")
    }
}