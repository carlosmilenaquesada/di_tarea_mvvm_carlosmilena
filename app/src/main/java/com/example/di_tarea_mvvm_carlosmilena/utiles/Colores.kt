package com.example.di_tarea_mvvm_carlosmilena.utiles

import androidx.compose.ui.graphics.Color


fun getColores(): HashMap<String, Array<Color>> {
    return hashMapOf(
        "Normal" to arrayOf(Color(0xFFA8A77A), Color.Black),
        "Fire" to arrayOf(Color(0xFFEE8130), Color.White),
        "Water" to arrayOf(Color(0xFF6390F0), Color.White),
        "Electric" to arrayOf(Color(0xFFF7D02C), Color.Black),
        "Grass" to arrayOf(Color(0xFF7AC74C), Color.Black),
        "Ice" to arrayOf(Color(0xFF96D9D6), Color.Black),
        "Fighting" to arrayOf(Color(0xFFC22E28), Color.White),
        "Poison" to arrayOf(Color(0xFFA33EA1), Color.White),
        "Ground" to arrayOf(Color(0xFFE2BF65), Color.Black),
        "Flying" to arrayOf(Color(0xFFA98FF3), Color.Black),
        "Psychic" to arrayOf(Color(0xFFF95587), Color.White),
        "Bug" to arrayOf(Color(0xFFA6B91A), Color.White),
        "Rock" to arrayOf(Color(0xFFB6A136), Color.White),
        "Ghost" to arrayOf(Color(0xFF735797), Color.White),
        "Dragon" to arrayOf(Color(0xFF6F35FC), Color.White),
        "Dark" to arrayOf(Color(0xFF705746), Color.White),
        "Steel" to arrayOf(Color(0xFFB7B7CE), Color.Black),
        "Fairy" to arrayOf(Color(0xFFD685AD), Color.Black)
    )
}

