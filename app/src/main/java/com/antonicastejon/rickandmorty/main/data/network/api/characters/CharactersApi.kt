package com.antonicastejon.rickandmorty.main.data.network.api.characters

import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersApi {

    @GET("character/")
    suspend fun getCharacterList(
        @Query("page") page: Int = 1,
    ): CharactersResult
}
