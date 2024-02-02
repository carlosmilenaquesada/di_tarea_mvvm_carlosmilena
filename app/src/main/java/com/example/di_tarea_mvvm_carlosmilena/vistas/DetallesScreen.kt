package com.example.di_tarea_mvvm_carlosmilena.vistas


import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.di_tarea_mvvm_carlosmilena.R
import com.example.di_tarea_mvvm_carlosmilena.model.BaseStats
import com.example.di_tarea_mvvm_carlosmilena.model.Name
import com.example.di_tarea_mvvm_carlosmilena.model.Pokemon
import com.example.di_tarea_mvvm_carlosmilena.model.Profile
import com.example.di_tarea_mvvm_carlosmilena.utiles.Color_120_149
import com.example.di_tarea_mvvm_carlosmilena.utiles.Color_150_255
import com.example.di_tarea_mvvm_carlosmilena.utiles.Color_1_29
import com.example.di_tarea_mvvm_carlosmilena.utiles.Color_30_59
import com.example.di_tarea_mvvm_carlosmilena.utiles.Color_60_89
import com.example.di_tarea_mvvm_carlosmilena.utiles.Color_90_119
import java.util.*
import kotlin.reflect.full.memberProperties


@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetallesScreen(navController: NavController, pokemon: Pokemon) {

    Scaffold(topBar = {
        TopAppBar(actions = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Volver",
                    tint = Color.White
                )
            }
        },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Color(0xFF1E4C87)),
            title = {
                Text(text = "Detalles", color = Color.White)
            })
    }) { contentPadding ->
        Box(
            modifier = Modifier.padding(contentPadding)
        ) {

            PokemonCard(pokemon = pokemon)
        }
    }

}


@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun PokemonCard(pokemon: Pokemon) {


    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ), shape = RoundedCornerShape(4.dp), modifier = Modifier
            .padding(10.dp)
            .wrapContentHeight()

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.container_bg),
                contentDescription = "background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                /*NUMERO Y NOMBRE*/
                Row(
                    horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = pokemon.name.english,
                        fontSize = 25.sp,
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )

                    Text(
                        text = "N.º " + pokemon.id.toString().padStart(4, '0'),
                        fontSize = 25.sp,
                        color = Color(0XFF616161),
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                }
                /**
                 * IMAGEN*/
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current).data(pokemon.image.hires)
                        .build(),
                    modifier = Modifier
                        .width(200.dp)
                        .height(200.dp)
                        .padding(5.dp),
                    contentDescription = pokemon.name.english,
                    contentScale = ContentScale.Fit
                )

                /**
                 * IDIOMAS*/
                MiElevatedCard(
                    "Name (Other countries)", Color(0XFF7FB9C9)
                ) {
                    GenerarIdiomas(pokemon = pokemon)
                }

                /**
                 * DESCRIPCIÓN*/
                MiElevatedCard("Description", Color(0XFF9ACCD7)) {
                    Text(
                        text = pokemon.description, textAlign = TextAlign.Justify
                    )
                }

                /**
                 * BASE STATS*/
                MiElevatedCard(
                    titulo = "Base Stats", color = Color(0XFF4C7391)
                ) {
                    GenerarStats(pokemon = pokemon)
                }


                /**
                 * PROFILES*/
                MiElevatedCard(
                    titulo = "Profiles", color = Color(0XFF5C8CA3)
                ) {
                    GenerarProfiles(pokemon = pokemon)
                }


            }


        }
    }
}


@Composable
fun GenerarProfiles(pokemon: Pokemon) {
    Profile::class.memberProperties.forEach { member ->
        val name = member.name
        val value = member.get(pokemon.profile) as Any
        Row {
            Text(
                text = name.capitalize(), color = Color.White, modifier = Modifier.weight(0.3f)
            )
            var valor: String = ""

            if (value is List<*>) {
                listOf(value).forEach { l ->
                    valor = l.toString().replace("[", "").replace("]", "").replace(", true", "")
                        .replace(", false", "")
                }
            } else {
                valor = value.toString().replace("[", "").replace("]", "").replace(", true", "")
                    .replace(", false", "")
            }
            Text(
                text = valor, color = Color.Black, modifier = Modifier.weight(0.7f)

            )
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}


@Composable
fun GenerarIdiomas(pokemon: Pokemon) {
    Name::class.memberProperties.forEach { member ->
        val name = member.name
        val value = member.get(pokemon.name) as String
        Text(
            text = "${name.capitalize()} $value",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )
    }
}

@Composable
fun GenerarStats(pokemon: Pokemon) {
    BaseStats::class.memberProperties.forEach { member ->
        val name = member.name
        val value = member.get(pokemon.base) as Integer
        Row {
            Text(
                text = name, color = Color.White, modifier = Modifier.weight(0.3f)
            )
            Text(
                text = value.toString(), color = Color.Black, modifier = Modifier.weight(0.1f)
            )
            LinearProgressIndicator(
                progress = value.toFloat() / 255f,
                color = when (value.toInt()) {
                    in 1..29 -> Color_1_29
                    in 30..59 -> Color_30_59
                    in 60..89 -> Color_60_89
                    in 90..119 -> Color_90_119
                    in 120..149 -> Color_120_149
                    in 150..255 -> Color_150_255
                    else -> Color.Blue
                }, modifier = Modifier
                    .height(16.dp)
                    .weight(0.6f)
            )

        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}


@Composable
fun MiElevatedCard(
    titulo: String,
    color: Color,
    miFuncion: @Composable () -> Unit,
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ), shape = RoundedCornerShape(4.dp), modifier = Modifier.wrapContentHeight()
    ) {
        Column(
            modifier = Modifier
                .background(color = color)
                .padding(15.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = titulo,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp)
            )
            miFuncion()
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}