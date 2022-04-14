package com.geekmk.droidcon.data.local

import androidx.room.ColumnInfo
import androidx.room.ColumnInfo.TEXT
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class Todo(

        @PrimaryKey(autoGenerate = true) val id: Int,

        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "created_ts")
        var createdTime: Long,
)