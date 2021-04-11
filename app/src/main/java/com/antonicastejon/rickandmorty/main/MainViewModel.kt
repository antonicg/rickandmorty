package com.antonicastejon.rickandmorty.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antonicastejon.rickandmorty.main.domain.characters.CharactersDataSource
import com.antonicastejon.rickandmorty.main.entities.CharacterViewEntity
import com.antonicastejon.rickandmorty.main.entities.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dataSource: CharactersDataSource
) : ViewModel() {

    private val _state: MutableLiveData<MainState> = MutableLiveData()
    val state: LiveData<MainState> = _state

    init {
        viewModelScope.launch {
            val viewEntities = dataSource.fetchCharacters()
                .map { CharacterViewEntity(it.name, it.specie, it.origin) }
            _state.value = MainState(characterList = viewEntities)
        }
    }
}
