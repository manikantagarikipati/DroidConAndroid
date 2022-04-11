package com.geekmk.droidcon.todolist

import android.view.MenuItem
import androidx.lifecycle.ViewModel
import com.geekmk.droidcon.R
import com.geekmk.droidcon.R.id.addItem
import com.geekmk.droidcon.domain.usecase.AddTodoListItemUseCase
import com.geekmk.droidcon.domain.usecase.FetchTodoListUseCase
import com.geekmk.droidcon.todolist.adapter.TodoListAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoListViewModel @Inject constructor(
        private val fetchTodoListUseCase: FetchTodoListUseCase,
        private val addTodoListItemUseCase: AddTodoListItemUseCase,
        val todoListAdapter: TodoListAdapter
) : ViewModel() {

    fun fetchTodoList() {
        val listItems = fetchTodoListUseCase.execute().map {
            TodoListViewDataModel(it.title, it.createdTs.toString())
        }
        todoListAdapter.updateListItems(listItems)
    }

    fun addTodoItem() {
        val insertedItem = addTodoListItemUseCase.execute(title = "DroidConf Info").let {
            TodoListViewDataModel(it.title, it.createdTs.toString())
        }
        todoListAdapter.addItem(insertedItem)
    }

    fun onOptionsItemSelected(it: MenuItem):Boolean {
        //adding a random title for demo purpose, in realtime display a form to collect data
        addTodoItem()
        return true
    }
}