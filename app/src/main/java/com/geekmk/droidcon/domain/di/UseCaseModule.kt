package com.geekmk.droidcon.domain.di

import com.geekmk.droidcon.domain.usecase.AddTodoListItemUseCase
import com.geekmk.droidcon.domain.usecase.AddTodoListItemUseCaseImpl
import com.geekmk.droidcon.domain.usecase.FetchTodoListUseCase
import com.geekmk.droidcon.domain.usecase.FetchTodoListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindFetchTodoListUseCase(fetchTodoListUseCase: FetchTodoListUseCaseImpl): FetchTodoListUseCase

    @Binds
    abstract fun bindAddTodoListUseCase(addTodoListItemUseCase: AddTodoListItemUseCaseImpl): AddTodoListItemUseCase

}