package com.antonicastejon.rickandmorty.main.data.network.api.characters

import kotlinx.serialization.Serializable

@Serializable
data class CharactersResult(
    val results: List<CharacterRaw>
)

@Serializable
data class CharacterRaw(
    val id: Int,
    val name: String,
    val species: String,
    val origin: CharacterOriginRaw
)

@Serializable
data class CharacterOriginRaw(
    val name: String
)
