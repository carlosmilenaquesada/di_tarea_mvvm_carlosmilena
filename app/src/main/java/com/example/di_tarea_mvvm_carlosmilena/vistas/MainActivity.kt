package com.example.di_tarea_mvvm_carlosmilena.vistas

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.di_tarea_mvvm_carlosmilena.controladores.AppNavigation
import com.example.di_tarea_mvvm_carlosmilena.ui.theme.Di_tarea_mvvm_carlosmilenaTheme
import com.example.di_tarea_mvvm_carlosmilena.viewmodel.PokemonViewModel

class MainActivity : ComponentActivity() {
    val pokemonViewModel by viewModels<PokemonViewModel>()
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Di_tarea_mvvm_carlosmilenaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation(pokemonViewModel)
                }
            }
        }
    }
}




/*class MainActivity : ComponentActivity() {


    val pokemonViewModel by viewModels<PokemonViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitCrazyColumnTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    PokemonList(
                        pokemonList = pokemonViewModel.pokemonListResponse,
                        pokemonViewModel.getErrorCon()
                    )
                    pokemonViewModel.getPokemonList()
                }
            }

        }
    }
}


@Composable
fun PokemonList(pokemonList: List<Pokemon>, error: Boolean) {
    if (error)
        Box(Modifier.fillMaxSize()) {
            Text(text = "Error de conexión",
                modifier = Modifier.align(Alignment.Center),
                fontSize = 30.sp)
        }
    else
        LazyVerticalGrid(columns = GridCells.Fixed(3),
            content = {
            itemsIndexed(items = pokemonList) { index, item ->
                PokemonItem(pokemon = item)
            }
        })
}
*/


