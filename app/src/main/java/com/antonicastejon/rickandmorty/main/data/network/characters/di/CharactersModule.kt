package com.antonicastejon.rickandmorty.main.data.network.characters.di

import com.antonicastejon.rickandmorty.di.IO
import com.antonicastejon.rickandmorty.main.data.network.api.characters.CharactersApi
import com.antonicastejon.rickandmorty.main.data.network.characters.CharactersDataSourceFromNetwork
import com.antonicastejon.rickandmorty.main.domain.characters.CharactersDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.CoroutineDispatcher
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
class CharactersModule {

    @Provides
    fun provideCharactersApiService(
        retrofit: Retrofit,
        @IO coroutineDispatcher: CoroutineDispatcher
    ): CharactersDataSource =
        CharactersDataSourceFromNetwork(
            retrofit.create(CharactersApi::class.java),
            coroutineDispatcher
        )
}
