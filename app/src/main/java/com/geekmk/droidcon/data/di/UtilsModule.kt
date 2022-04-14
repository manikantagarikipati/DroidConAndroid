package com.geekmk.droidcon.data.di

import com.geekmk.droidcon.data.utils.TimeUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UtilsModule {

    @Provides
    @Singleton
    fun provideTimeUtil():TimeUtil{
        return TimeUtil()
    }
}