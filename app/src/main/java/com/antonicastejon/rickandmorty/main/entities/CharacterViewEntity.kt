package com.antonicastejon.rickandmorty.main.entities

data class MainState(
    val characterList: List<CharacterViewEntity>
)

data class CharacterViewEntity(
    val name: String,
    val specie: String,
    val origin: String
)

val defaultMainState = MainState(emptyList())
