package com.example.di_tarea_mvvm_carlosmilena.controladores

//import androidx.compose.ui.tooling.data.EmptyGroup.name
import android.os.Build
import android.util.Log.*
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.di_tarea_mvvm_carlosmilena.model.Pokemon
import com.example.di_tarea_mvvm_carlosmilena.viewmodel.LoginViewModel
import com.example.di_tarea_mvvm_carlosmilena.viewmodel.PokemonViewModel
import com.example.di_tarea_mvvm_carlosmilena.vistas.AutenticacionScreen
import com.example.di_tarea_mvvm_carlosmilena.vistas.CatalogoScreen
import com.example.di_tarea_mvvm_carlosmilena.vistas.DetallesScreen
import com.example.di_tarea_mvvm_carlosmilena.vistas.InicioScreen
import com.google.gson.Gson
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun AppNavigation(pokemonViewModel: PokemonViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.InicioScreen.route) {
        composable(route = AppScreens.InicioScreen.route) {
            InicioScreen(navController)
        }

        composable(route = AppScreens.AutenticacionScreen.route) {
            AutenticacionScreen(navController, LoginViewModel())
        }

        composable(route = AppScreens.CatalogoScreen.route) {
            CatalogoScreen(navController, pokemonViewModel)
        }

        composable(
            route = AppScreens.DetallesScreen.route + "/{text}",
            arguments = listOf(navArgument(name = "text") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("text")?.let { json ->
                var decode = URLDecoder.decode(json, StandardCharsets.UTF_8.toString())
                var pokemon = Gson().fromJson(decode, Pokemon::class.java)
                DetallesScreen(navController, pokemon)
            }
        }

    }
}
