package com.geekmk.droidcon.todolist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.geekmk.droidcon.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoListFragment : Fragment() {

    private lateinit var viewModel: TodoListViewModel

    companion object {
        fun newInstance(): TodoListFragment = TodoListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =  ViewModelProvider(this).get(TodoListViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.fragment_todolist,container,false)
        setHasOptionsMenu(true)
        view.findViewById<RecyclerView>(R.id.recyclerViewTodoList).apply {
            adapter = viewModel.todoListAdapter
        }
        viewModel.fetchTodoList()
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.todo_menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
            item.let { viewModel.onOptionsItemSelected(it) }
}
