package com.geekmk.droidcon.todolist

import android.view.MenuItem
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geekmk.droidcon.R.id.addItem
import com.geekmk.droidcon.domain.usecase.AddTodoListItemUseCase
import com.geekmk.droidcon.domain.usecase.FetchTodoListUseCase
import com.geekmk.droidcon.todolist.adapter.TodoListAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
        private val fetchTodoListUseCase: FetchTodoListUseCase,
        private val addTodoListItemUseCase: AddTodoListItemUseCase,
        val todoListAdapter: TodoListAdapter
) : ViewModel() {

    fun fetchTodoList() {
        viewModelScope.launch(Dispatchers.IO) {
            val listItems = fetchTodoListUseCase.execute().map {
                TodoListViewDataModel(it.title, it.createdTs.toString())
            }
            withContext(Dispatchers.Main) {
                todoListAdapter.updateListItems(listItems)
            }
        }
    }

    fun addTodoItem() {
        viewModelScope.launch(Dispatchers.IO) {
            val insertedItem = addTodoListItemUseCase.execute(title = "DroidConf Info").let {
                TodoListViewDataModel(it.title, it.createdTs.toString())
            }
            withContext(Dispatchers.Main) {
                todoListAdapter.addItem(insertedItem)
            }
        }
    }

    fun onOptionsItemSelected(it: MenuItem): Boolean {
        //adding a random title for demo purpose, in realtime display a form to collect data
        return when (it.itemId) {
            addItem -> {
                addTodoItem()
                true
            }
            else -> {
                false
            }
        }
    }
}
