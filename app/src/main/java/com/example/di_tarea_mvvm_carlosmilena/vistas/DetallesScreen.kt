package com.example.di_tarea_mvvm_carlosmilena.vistas


import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.di_tarea_mvvm_carlosmilena.R
import com.example.di_tarea_mvvm_carlosmilena.model.Pokemon
import java.util.*


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetallesScreen(navController: NavController, pokemon: Pokemon) {

    Scaffold(topBar = {
        TopAppBar(
            actions = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Volver",
                        tint = Color.White
                    )
                }
            }, colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF495D92)),
            title = {
                Text(text = "Detalles de juegos", color = Color.White)
            }
        )
    }) { contentPadding ->
        Box(
            modifier = Modifier
                .padding(contentPadding)
        ) {
            Image(
                painter = painterResource(id = R.drawable.background_inicio),
                contentDescription = "background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )
            ContenidoDetalles(navController, pokemon)
        }
    }

}

@Composable
fun ContenidoDetalles(navController: NavController, pokemon: Pokemon) {

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background_inicio),
            contentDescription = "background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        PokemonCard(pokemon = pokemon)
    }
}

@Composable
fun PokemonCard(pokemon: Pokemon) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = pokemon.name.english,
                    modifier = Modifier.padding(horizontal = 5.dp)
                )

                Text(
                    text = "N.º " + pokemon.id.toString().padStart(4, '0'),
                    color = Color(0XFF616161),
                    modifier = Modifier.padding(horizontal = 5.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(pokemon.image.hires)
                    .build(),
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .background(Color(0XFFF2F2F2))
                    .padding(5.dp),
                contentDescription = pokemon.name.english, contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(8.dp))

            /*
             Card(
                 shape = RoundedCornerShape(4.dp),
                 modifier = Modifier
                     .padding(16.dp)
             ) {
                 Text(
                     text = "Name (Other countries)",
                     textAlign = TextAlign.Center,
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(5.dp)
                 )
                 Text(
                     text = "English: ${pokemon.name.english}",
                     textAlign = TextAlign.Center,
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(5.dp)
                 )
                 Text(
                     text = "Japanese: ${pokemon.name.japanese}",
                     textAlign = TextAlign.Center,
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(5.dp)
                 )
                 Text(
                     text = "Chinese: ${pokemon.name.chinese}",
                     textAlign = TextAlign.Center,
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(5.dp)
                 )
                 Text(
                     text = "French: ${pokemon.name.french}",
                     textAlign = TextAlign.Center,
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(5.dp)
                 )

             }


             Spacer(modifier = Modifier.height(8.dp))


             Card(
                 shape = RoundedCornerShape(4.dp),
                 modifier = Modifier
                     .padding(16.dp)
             ) {
                 Text(
                     text = "Type",
                     textAlign = TextAlign.Center,
                     modifier = Modifier
                         .fillMaxWidth()
                         .padding(5.dp)
                 )

                 Text(
                     text = "Type: ${pokemon.type.joinToString()}",
                     style = MaterialTheme.typography.bodyLarge
                 )

             }


             Spacer(modifier = Modifier.height(8.dp))



             Card(
                 shape = RoundedCornerShape(4.dp),
                 modifier = Modifier
                     .padding(16.dp)
             ) {
                 Column {
                     Text(
                         text = "Base Stats",
                         textAlign = TextAlign.Center,
                         modifier = Modifier
                             .padding(5.dp)
                             .fillMaxWidth()
                     )
                     Text(text = "HP: ${pokemon.base.HP}")
                     Text(text = "Attack: ${pokemon.base.Attack}")
                     Text(text = "Defense: ${pokemon.base.Defense}")
                     Text(text = "Sp. Attack: ${pokemon.base.SpAttack}")
                     Text(text = "Sp. Defense: ${pokemon.base.SpDefense}")
                     Text(text = "Speed: ${pokemon.base.Speed}")
                 }

             }


             Spacer(modifier = Modifier.height(8.dp))

 Card(
                 shape = RoundedCornerShape(4.dp),
                 modifier = Modifier
                     .padding(16.dp)
             ) {
                 Text(
                     text = "Description",
                     textAlign = TextAlign.Center,
                     modifier = Modifier
                         .padding(5.dp)
                         .fillMaxWidth()
                 )
                 Text(
                     text = pokemon.description,
                     style = MaterialTheme.typography.bodyMedium
                 )
             }*/

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

            ) {
                Column(
                    modifier = Modifier
                        .background(Color(0XFF30A7D7))
                        .fillMaxWidth()
                        .padding(5.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "Profile",
                        style = MaterialTheme.typography.titleLarge,
                        textAlign = TextAlign.Center,
                        color = Color.Black, modifier = Modifier.fillMaxWidth()
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier
                                .weight(0.4f)
                                .padding(start = 10.dp, end= 10.dp, top = 10.dp),
                            text = "Height",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.White
                        )
                        Text(
                            modifier = Modifier
                                .weight(0.4f)
                                .padding(start = 10.dp, end= 10.dp, top = 10.dp),
                            text = "Species",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.White
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier
                                .weight(0.4f)
                                .padding(start = 10.dp, end= 10.dp, bottom = 10.dp, top = 5.dp),
                            text = pokemon.profile.height,
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.Black
                        )
                        Text(
                            modifier = Modifier
                                .weight(0.4f)
                                .padding(start = 10.dp, end= 10.dp, bottom = 10.dp, top = 5.dp),
                            text = pokemon.species,
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.Black
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier
                                .weight(0.4f)
                                .padding(start = 10.dp, end= 10.dp, top = 10.dp),
                            text = "Weight",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.White
                        )
                        Text(
                            modifier = Modifier
                                .weight(0.4f)
                                .padding(start = 10.dp, end= 10.dp, top = 10.dp),
                            text = "Ability",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.White
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier
                                .weight(0.4f)
                                .padding(start = 10.dp, end= 10.dp, bottom = 10.dp, top = 5.dp),
                            text = pokemon.profile.weight,
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.Black
                        )
                        Text(
                            modifier = Modifier
                                .weight(0.4f)
                                .padding(start = 10.dp, end= 10.dp, bottom = 10.dp, top = 5.dp),
                            text = pokemon.profile.ability[0].filter { s -> s != "true" && s != "false" }
                                .joinToString(),
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.Black
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier
                                .weight(0.4f)
                                .padding(start = 10.dp, end= 10.dp, top = 10.dp),
                            text = "Gender",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.White
                        )
                        Text(
                            modifier = Modifier
                                .weight(0.4f)
                                .padding(start = 10.dp, end= 10.dp, top = 10.dp),
                            text = "Hidden ability",
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.White
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier
                                .weight(0.4f)
                                .padding(start = 10.dp, end= 10.dp, bottom = 10.dp, top = 5.dp),
                            text = pokemon.profile.gender,
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.Black
                        )
                        Text(
                            modifier = Modifier
                                .weight(0.4f)
                                .padding(start = 10.dp, end= 10.dp, bottom = 10.dp, top = 5.dp),
                            text = if (pokemon.profile.ability.size > 1) {
                                pokemon.profile.ability[1].filter { s -> s != "true" && s != "false" }
                                    .joinToString()
                            } else {
                                "N/A"
                            },
                            style = MaterialTheme.typography.titleLarge,
                            color = Color.Black
                        )
                    }
                }
            }

        }
    }
}