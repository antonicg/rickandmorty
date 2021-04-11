package com.antonicastejon.rickandmorty.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.antonicastejon.rickandmorty.main.entities.MainState
import com.antonicastejon.rickandmorty.main.entities.CharacterViewEntity
import com.antonicastejon.rickandmorty.main.entities.defaultMainState

@Composable
fun mainScreen(mainViewModel: MainViewModel) {
    val state: MainState by mainViewModel.state.observeAsState(defaultMainState)
    
    characterList(state = state)
}

@Composable
fun characterList(state: MainState) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        items(state.characterList) { viewEntity ->
            characterItem(viewEntity)
        }
    }
}

@Composable
fun characterItem(characterViewEntity: CharacterViewEntity) {
    MaterialTheme {
        Column {
            Text(characterViewEntity.name, style = typography.body1)
            Row {
                Text(characterViewEntity.specie, style = typography.caption, modifier = Modifier.padding(end = 5.dp))
                Text(characterViewEntity.origin, style = typography.caption)
            }
        }
    }
}

@Preview
@Composable
fun mainPreview() {
    characterList(state = MainState(charactersPrview))
}

val charactersPrview = listOf(
    CharacterViewEntity("Rick", "Human", "Earth"),
    CharacterViewEntity("Morty", "Human", "Earth"),
)
