package com.example.di_tarea_mvvm_carlosmilena.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.di_tarea_mvvm_carlosmilena.controladores.AppScreens
import com.example.di_tarea_mvvm_carlosmilena.model.Pokemon
import com.example.di_tarea_mvvm_carlosmilena.utiles.getColores
import com.google.gson.Gson
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun PokemonItem(pokemon: Pokemon, navController: NavController) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(10.dp)
            .wrapContentHeight()
            .clickable(onClick = {
                var pokemonJson = Gson().toJson(pokemon, Pokemon::class.java)
                var encode = URLEncoder.encode(pokemonJson, StandardCharsets.UTF_8.toString())
                navController.navigate(AppScreens.DetallesScreen.route + "/$encode")
            }),
    )
    {

        Column (modifier = Modifier.background(Color.White)){
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(pokemon.image.hires)
                    .build(),
                modifier = Modifier
                    .fillMaxWidth().height(200.dp).background(Color(0XFFF2F2F2)).padding(5.dp),
                contentDescription = pokemon.name.english, contentScale = ContentScale.Fit
            )
            Text(
                text = "N.º" + pokemon.id.toString().padStart(4, '0'),
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0XFF919191),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 5.dp)

            )



            Text(
                text = pokemon.name.english,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            )
            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Box(
                    modifier = Modifier.weight(1f)
                        .padding(start = 10.dp, end = 5.dp, bottom = 8.dp, top = 8.dp)
                ) {

                    Text(
                        text = pokemon.type[0],
                        style = MaterialTheme.typography.bodyMedium,
                        color = getColores()[pokemon.type[0]]?.get(1) ?: Color.Black,
                        textAlign = TextAlign.Center, modifier = Modifier
                            .background(
                                getColores()[pokemon.type[0]]?.get(0) ?: Color.White,
                                shape = RoundedCornerShape(4.dp)
                            ).fillMaxWidth().padding(vertical = 2.dp)
                    )
                }

                Box(
                    modifier = Modifier.weight(1f)
                        .padding(start = 5.dp, end = 10.dp, bottom = 8.dp, top = 8.dp)
                ) {
                    if (pokemon.type.size > 1) {
                        Text(
                            text = pokemon.type[1],
                            style = MaterialTheme.typography.bodyMedium,
                            color = getColores()[pokemon.type[1]]?.get(1) ?: Color.Black,
                            textAlign = TextAlign.Center, modifier = Modifier
                                .background(
                                    getColores()[pokemon.type[1]]?.get(0) ?: Color.White,
                                    shape = RoundedCornerShape(4.dp)
                                ).fillMaxWidth().padding(vertical = 2.dp)
                        )
                    }
                }
            }

        }


    }

}