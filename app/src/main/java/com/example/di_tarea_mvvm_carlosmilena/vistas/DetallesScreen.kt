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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
            .padding(16.dp).background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = pokemon.name.english,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )

                    Text(
                        text = "N.º " + pokemon.id.toString().padStart(4, '0'),
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                }

            }
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current).data(pokemon.image.hires)
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(8.dp))

            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = "Name (Other countries)",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "English: ${pokemon.name.english}",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Japanese: ${pokemon.name.japanese}",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Chinese: ${pokemon.name.chinese}",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "French: ${pokemon.name.french}",
                    fontWeight = FontWeight.Bold
                )

            }


            Spacer(modifier = Modifier.height(8.dp))

            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = "Type",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Type: ${pokemon.type.joinToString()}",
                    style = MaterialTheme.typography.bodyLarge
                )

            }


            Spacer(modifier = Modifier.height(8.dp))

            // Display Pokemon Base Stats
            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = "Base Stats",
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
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
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = "Species",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = pokemon.species,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.height(8.dp))

            Card(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = "Description",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = pokemon.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Card(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = "Profile",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxWidth()
                )
                Text(
                    text = "Height: ${pokemon.profile.height}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Weight: ${pokemon.profile.weight}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Egg: ${pokemon.profile.egg.joinToString()}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Normal ability: ${
                        pokemon.profile.ability.get(0).filter { s -> s != "true" && s != "false" }
                            .joinToString()
                    }",
                    style = MaterialTheme.typography.bodyMedium
                )
                if (pokemon.profile.ability.size > 1) {


                    Text(
                        text = "Hidden ability: ${
                            pokemon.profile.ability.get(1)
                                .filter { s -> s != "true" && s != "false" }.joinToString()
                        }",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Text(
                    text = "Gender (male : female): ${pokemon.profile.gender}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}