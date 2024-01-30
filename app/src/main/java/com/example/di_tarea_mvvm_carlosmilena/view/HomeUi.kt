package com.example.di_tarea_mvvm_carlosmilena.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.di_tarea_mvvm_carlosmilena.controladores.AppScreens
import com.example.di_tarea_mvvm_carlosmilena.model.Pokemon
import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun PokemonItem(pokemon: Pokemon, navController: NavController) {
    Card(
        border = BorderStroke(2.dp, Color.Cyan),
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .height(150.dp)
            .clickable(onClick = {
                var pokemonJson = Gson().toJson(pokemon, Pokemon::class.java)
                var encode = URLEncoder.encode(pokemonJson, StandardCharsets.UTF_8.toString())
                navController.navigate(AppScreens.DetallesScreen.route + "/$encode")
            }),
    )
    {

        Column(modifier = Modifier.fillMaxHeight()) {
            Text(
                text = "POKEDEX#" + pokemon.id.toString().padStart(3, '0'),
                style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold, modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            )

            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(pokemon.image.thumbnail)//movie.imageUrl)
                    .build(),
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.3f)
                    .fillMaxWidth(),
                contentDescription = pokemon.name.english
            )

            Text(
                text = pokemon.name.english.uppercase(),
                style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            )

        }


    }

}