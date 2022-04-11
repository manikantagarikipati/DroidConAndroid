package com.geekmk.droidcon.data.local

import androidx.room.ColumnInfo
import androidx.room.ColumnInfo.TEXT
import androidx.room.Entity

@Entity(tableName = "TodoItem")
data class TodoItem(
        @ColumnInfo(name = "title", typeAffinity = TEXT)
        var title: String,

        @ColumnInfo(name = "created_ts")
        var createdTime: String,
)