package com.antonicastejon.rickandmorty.main.data.network.characters

import com.antonicastejon.rickandmorty.main.data.network.api.characters.CharacterOriginRaw
import com.antonicastejon.rickandmorty.main.data.network.api.characters.CharacterRaw
import com.antonicastejon.rickandmorty.main.data.network.api.characters.CharactersApi
import com.antonicastejon.rickandmorty.main.data.network.api.characters.CharactersResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Test
import com.antonicastejon.rickandmorty.main.domain.characters.Character

@ExperimentalCoroutinesApi
internal class CharactersDataSourceFromNetworkTest {

    private val testCoroutineDispatcher = TestCoroutineDispatcher()
    private val apiService = object: CharactersApi {
        override suspend fun getCharacterList(page: Int) = response
    }

    private val sut = CharactersDataSourceFromNetwork(
        apiService,
        testCoroutineDispatcher
    )

    @Test
    fun `characters list should be fetched`() {
        runBlocking {
            val characters = sut.fetchCharacters()
            val expected = listOf(
                Character("characterName", "specie", "from")
            )

            assert(characters == expected)
        }
    }

    private companion object {
        private val response = CharactersResult(
            listOf(
                CharacterRaw(
                    1,
                    "characterName",
                    "specie",
                    CharacterOriginRaw("from")
                )
            )
        )
    }
}
