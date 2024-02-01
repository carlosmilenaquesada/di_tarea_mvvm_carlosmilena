package com.example.di_tarea_mvvm_carlosmilena.vistas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.di_tarea_mvvm_carlosmilena.controladores.AppScreens
import com.example.di_tarea_mvvm_carlosmilena.model.Pokemon
import com.example.di_tarea_mvvm_carlosmilena.view.PokemonItem
import com.example.di_tarea_mvvm_carlosmilena.viewmodel.PokemonViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CatalogoScreen(navController: NavController, pokemonViewModel: PokemonViewModel) {

    Scaffold(topBar = {
        TopAppBar(
            actions = {
            IconButton(onClick = { navController.navigate(AppScreens.InicioScreen.route) }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Volver",
                    tint = Color.White
                )
            }
        },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF1E4C87)),
            title = {
                Text(text = "Pokédex", color = Color.White)
            })
    }) { contentPadding ->
        Box(
            modifier = Modifier.padding(contentPadding)
        ) {

            ContenidoCatalogo(
                pokemonList = pokemonViewModel.pokemonListResponse,
                pokemonViewModel.getErrorCon(),
                navController
            )
            pokemonViewModel.getPokemonList()
        }
    }
}

@Composable
fun ContenidoCatalogo(pokemonList: List<Pokemon>, error: Boolean, navController: NavController) {
    if (error) Box(Modifier.fillMaxSize()) {
        Text(
            text = "Error de conexión",
            modifier = Modifier.align(Alignment.Center),
            fontSize = 30.sp
        )
    }
    else LazyVerticalGrid(modifier = Modifier, columns = GridCells.Fixed(2), content = {
        itemsIndexed(items = pokemonList) { index, item ->
            PokemonItem(pokemon = item, navController)
        }
    })
}
