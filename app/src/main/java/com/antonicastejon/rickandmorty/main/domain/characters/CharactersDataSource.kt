package com.antonicastejon.rickandmorty.main.domain.characters

interface CharactersDataSource {

    suspend fun fetchCharacters(): List<Character>
}
