package com.geekmk.droidcon.domain.usecase

import com.geekmk.droidcon.data.model.TodoDataItem
import com.geekmk.droidcon.data.repository.TodoListRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.doThrow
import org.mockito.kotlin.mock
import org.mockito.kotlin.stub

class AddTodoListItemUseCaseImplTest {
    lateinit var useCase: AddTodoListItemUseCase

    private val repository = mock<TodoListRepository>()

    @BeforeEach
    fun setUp() {
        useCase = AddTodoListItemUseCaseImpl(repository)
    }

    @Test
    fun `addTodoItem should return the added item`() {

        repository.stub {
            on { addTodoItem("title") } doReturn TodoDataItem("title",1234)
        }

        Assertions.assertEquals(TodoDataItem("title", 1234), repository.addTodoItem("title"))
    }

    @Test
    fun `addTodoItem should throw error when adding an item fails`() {
        repository.stub {
            on { addTodoItem("title") } doThrow Exception("Error adding item")
        }

        val exception = assertThrows<java.lang.Exception> { repository.addTodoItem("title") }
        Assertions.assertEquals("Error adding item", exception.message)
    }
}