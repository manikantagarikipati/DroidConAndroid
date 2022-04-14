package com.geekmk.droidcon.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TodoDao {
    @Query("SELECT * FROM todo")
    fun getAll(): List<Todo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg todos: Todo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(todo: Todo):Long

    @Query("SELECT * FROM todo WHERE id=:id")
    fun loadSingle(id: Long): Todo

    @Delete
    fun delete(todoItem: Todo)

    @Query("DELETE FROM todo")
    fun deleteAll()
}