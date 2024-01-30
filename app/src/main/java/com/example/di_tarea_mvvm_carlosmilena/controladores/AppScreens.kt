package com.example.di_tarea_mvvm_carlosmilena.controladores

sealed class AppScreens(val route: String){
    object InicioScreen: AppScreens("inicio_screen")
    object AutenticacionScreen: AppScreens("autenticacion_screen")
    object CatalogoScreen: AppScreens("catalogo_screen")
    object DetallesScreen: AppScreens("detalles_screen")

}
