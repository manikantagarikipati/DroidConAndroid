package com.geekmk.droidcon.data.model

import com.google.gson.annotations.SerializedName

data class TodoDataItem(
        val title: String,
        val createdTs: Long
)

data class TodoApiData(
        @SerializedName("title")
        val title: String,
        @SerializedName("createdTs")
        val createdTs: Long
)