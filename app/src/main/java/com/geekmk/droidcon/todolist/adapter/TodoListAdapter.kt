package com.geekmk.droidcon.todolist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.geekmk.droidcon.R
import com.geekmk.droidcon.todolist.TodoListViewDataModel
import javax.inject.Inject

class TodoListAdapter @Inject constructor(): RecyclerView.Adapter<TodoListAdapter.TodoListViewHolder>() {

    private val listItems = mutableListOf<TodoListViewDataModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todolist, parent, false)
        return TodoListViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoListViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount() = listItems.size

    class TodoListViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(todoListViewDataModel: TodoListViewDataModel) {
            view.findViewById<TextView>(R.id.tvTitle).text = todoListViewDataModel.title
            view.findViewById<TextView>(R.id.tvCreatedDate).text = todoListViewDataModel.createdTime
        }
    }

    fun updateListItems(updatedList:List<TodoListViewDataModel>){
        val initialSize = listItems.size
        listItems.addAll(updatedList)
        notifyItemRangeInserted(initialSize,updatedList.size)
    }

    fun addItem(todoListViewDataModel: TodoListViewDataModel){
        listItems.add(0,todoListViewDataModel)
        notifyItemInserted(0)
    }
}