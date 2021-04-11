package com.antonicastejon.rickandmorty.main.data.network.characters

import com.antonicastejon.rickandmorty.di.IO
import com.antonicastejon.rickandmorty.main.data.network.api.characters.CharactersApi
import com.antonicastejon.rickandmorty.main.data.network.api.characters.CharactersResult
import com.antonicastejon.rickandmorty.main.domain.characters.Character
import com.antonicastejon.rickandmorty.main.domain.characters.CharactersDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class CharactersDataSourceFromNetwork(
    private val service: CharactersApi,
    @IO private val dispatcher: CoroutineDispatcher
): CharactersDataSource {

    override suspend fun fetchCharacters(): List<Character> {
        val response = getCharacters()
        return response.results.map {
            Character(it.name, it.species, it.origin.name)
        }
    }

    private suspend fun getCharacters(): CharactersResult {
        return withContext(dispatcher) {
            service.getCharacterList()
        }
    }
}
