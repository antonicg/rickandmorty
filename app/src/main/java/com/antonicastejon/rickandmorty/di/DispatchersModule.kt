package com.antonicastejon.rickandmorty.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import javax.inject.Qualifier

@Module
@InstallIn(SingletonComponent::class)
class DispatchersModule {

    @Default
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Default

    @IO
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = IO

    @Main
    @Provides
    fun providesMainDispatcher(): CoroutineDispatcher = Main

}

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class Default

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class IO

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class Main
