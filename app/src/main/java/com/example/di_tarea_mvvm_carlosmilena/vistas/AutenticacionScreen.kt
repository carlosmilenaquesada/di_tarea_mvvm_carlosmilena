package com.example.di_tarea_mvvm_carlosmilena.vistas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.util.PatternsCompat
import androidx.navigation.NavController
import com.example.di_tarea_mvvm_carlosmilena.R
import com.example.di_tarea_mvvm_carlosmilena.controladores.AppScreens
import com.example.di_tarea_mvvm_carlosmilena.viewmodel.LoginViewModel
import kotlinx.coroutines.launch

@Composable
fun AutenticacionScreen(navController: NavController, loginViewModel: LoginViewModel) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ContenidoAutenticacion(
            Modifier.align(Alignment.Center),
            navController,
            viewModel = loginViewModel
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ContenidoAutenticacion(
    modifier: Modifier,
    navController: NavController,
    viewModel: LoginViewModel
) {
    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.password.observeAsState(initial = "")
    val loginEnable: Boolean by viewModel.loginEnable.observeAsState(initial = false)
    val isLoading: Boolean by viewModel.isLoading.observeAsState(initial = false)
    val coroutineScope = rememberCoroutineScope()


    /*var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }*/
    val keyboardController = LocalSoftwareKeyboardController.current
    //val contexto = LocalContext.current
    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    } else {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.background_inicio),
                contentDescription = "background",
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )

            Column(modifier = modifier) {
                Text(
                    text = "Identificarse",
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.padding(bottom = 16.dp)
                )


                EmailField(email) { viewModel.onLoginChanged(it, password) }
                Spacer(modifier = Modifier.padding(15.dp))
                PasswordField(password, keyboardController) { viewModel.onLoginChanged(email, it) }
                Spacer(modifier = Modifier.padding(15.dp))
                LoginButton(loginEnable, email, password) {
                    coroutineScope.launch {
                        viewModel.onLoginSelected()
                    }
                }
            }




            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {


                    Button(onClick = { navController.navigate(AppScreens.InicioScreen.route) }) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = null,
                                tint = Color.White
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = "Volver", color = Color.White)
                        }
                    }
                }
            }

        }
    }


}


@Composable
fun LoginButton(
    loginEnable: Boolean,
    email: String,
    password: String,
    onLoginSelected: () -> Unit
) {
    Button(
        onClick = {
            onLoginSelected()
        },
        enabled = PatternsCompat.EMAIL_ADDRESS.matcher(email)
            .matches() && password.isNotEmpty() && loginEnable
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = null,
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "Acceder", color = Color.White)
        }
    }


    /*Button(
        onClick = { onLoginSelected() }, modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        enabled = loginEnable
    ) {
        Text(text = "Iniciar")
    }*/
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailField(email: String, onTextFieldChanged: (String) -> Unit) {
    OutlinedTextField(
        value = email, onValueChange = { onTextFieldChanged(it) },
        label = { Text("Usuario (correo electrónico)") },
        placeholder = { Text(text = "Email") },
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = null,
                tint = Color.Black
            )
        },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        //keyboardActions = KeyboardActions(onNext = {}),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black,
            focusedLabelColor = Color.Black,
            cursorColor = Color.Black,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    )


    /*TextField(
        value = email, onValueChange = { onTextFieldChanged(it) },//--
        modifier = Modifier.fillMaxWidth(),//--
        placeholder = { Text(text = "Email") },//--
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),//--
        singleLine = true,//
        maxLines = 1//--
    )*/
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun PasswordField(
    password: String,
    keyboardController: SoftwareKeyboardController?,
    onTextFieldChanged: (String) -> Unit
) {
    OutlinedTextField(
        value = password, onValueChange = { onTextFieldChanged(it) },
        label = { Text("Contraseña") },
        placeholder = { Text(text = "Password") },
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = null,
                tint = Color.Black
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

        maxLines = 1,
        keyboardActions = KeyboardActions(onDone = {
            keyboardController?.hide()
        }),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Black,
            unfocusedBorderColor = Color.Black,
            focusedLabelColor = Color.Black,
            cursorColor = Color.Black
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    )


    /*TextField(
        value = password, onValueChange = { onTextFieldChanged(it) },//--
        modifier = Modifier.fillMaxWidth(),//--
        placeholder = { Text(text = "Password") },//--
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1
    )*/
}