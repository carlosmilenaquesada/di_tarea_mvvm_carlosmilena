package com.example.di_tarea_mvvm_carlosmilena.viewmodel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.di_tarea_mvvm_carlosmilena.model.Pokemon
import com.example.di_tarea_mvvm_carlosmilena.network.ApiService
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {

    var pokemonListResponse: List<Pokemon> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    var error: Boolean by mutableStateOf(false)
    fun getPokemonList() {
        viewModelScope.launch {
            val apiService = ApiService.getInstance()
            try {
                val pokemonList = apiService.getPokemon()
                pokemonListResponse = pokemonList
                error = false
            } catch (e: Exception) {
                errorMessage = e.message.toString()
                error = true
            }
        }
    }

    fun getErrorCon(): Boolean = error
}