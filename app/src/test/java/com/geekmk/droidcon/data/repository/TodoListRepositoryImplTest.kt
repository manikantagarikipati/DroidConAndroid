package com.geekmk.droidcon.data.repository

import com.geekmk.droidcon.data.local.Todo
import com.geekmk.droidcon.data.local.TodoDao
import com.geekmk.droidcon.data.model.TodoDataItem
import com.geekmk.droidcon.data.utils.TimeUtil
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.stub


class TodoListRepositoryImplTest {

    lateinit var repository: TodoListRepositoryImpl

    private val mockTodoDao = mock<TodoDao>()

    private val mockTimeUtil = mock<TimeUtil>()

    @BeforeEach
    fun setUp() {
        repository = TodoListRepositoryImpl(
                mockTimeUtil,
                mockTodoDao
        )
    }

    @Test
    fun `getListItems should return the todo items`() {

        mockTodoDao.stub {
            on { getAll() } doReturn listOf(Todo(1, "title", 1234))
        }

        Assertions.assertEquals(listOf(TodoDataItem("title", 1234)), repository.getListItems())
    }
}