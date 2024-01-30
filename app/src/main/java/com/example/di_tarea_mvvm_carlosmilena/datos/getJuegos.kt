package com.example.di_tarea_mvvm_carlosmilena.datos

import com.example.di_tarea_mvvm_carlosmilena.R
import com.example.di_tarea_mvvm_carlosmilena.model.Juego

fun getJuegos(): List<Juego> {
    return listOf(
        Juego("Bayonetta 2", "Nintendo Switch", R.drawable.nintendo_bayonetta2, 45.67f),
        Juego("Bayonetta 3", "Nintendo Switch", R.drawable.nintendo_bayonetta3, 76.89f),
        Juego("Capitan Tsubasa", "Nintendo Switch", R.drawable.nintendo_captainstsubasa, 30.45f),
        Juego("Mario + Rabbids", "Nintendo Switch", R.drawable.nintendo_mariorabbids, 55.12f),
        Juego("Kindom magestic", "Nintendo Switch", R.drawable.nintendo_kindommagestic, 62.34f),
        Juego("Mario Strinke", "Nintendo Switch", R.drawable.nintendo_mariostrike, 40.21f),
        Juego(
            "Moster Hunter Rise",
            "Nintendo Switch",
            R.drawable.nintendo_monsterhunterrise,
            80.98f
        ),
        Juego("Pikmin 4", "Nintendo Switch", R.drawable.nintendo_pikmin4, 25.76f),
        Juego("Mario Tennis", "Nintendo Switch", R.drawable.nintendo_maritennis, 37.89f),
        Juego("Two Point Campus", "PlayStation 5", R.drawable.playstation_2pointcampus, 65.43f),
        Juego("Crusader Kings 3", "PlayStation 5", R.drawable.playstation_crusaderkings3, 92.10f),
        Juego("Fifa 23", "PlayStation 5", R.drawable.playstation_fifa23, 48.75f),
        Juego("God Of War: Ragnarok", "PlayStation 5", R.drawable.playstation_gowragnarok, 88.23f),
        Juego(
            "Horizon: Call of the mountain",
            "PlayStation 5",
            R.drawable.playstation_horizonmontain,
            75.34f
        ),
        Juego("Minecraft Legend", "PlayStation 5", R.drawable.playstation_minecraftlegends, 19.99f),
        Juego("NBA 2k23", "PlayStation 5", R.drawable.playstation_nba2k23, 59.99f),
        Juego("PGA 2k23", "PlayStation 5", R.drawable.playstation_pga2k23, 39.99f),
        Juego("Stray", "PlayStation 5", R.drawable.playstation_stray, 50.50f),
        Juego("Age of empire 2", "XBox Series", R.drawable.xbox_ageofempire2, 29.99f),
        Juego("Crusader kings 3", "XBox Series", R.drawable.xbox_crusader_kings3, 85.00f),
        Juego("Dying Light 2", "XBox Series", R.drawable.xbox_dyinglight2, 42.56f),
        Juego("FarCry 6", "XBox Series", R.drawable.xbox_farcry6, 70.20f),
        Juego("FC 24", "XBox Series", R.drawable.xbox_fc24, 15.99f),
        Juego(
            "Jurassic World Evolution 2",
            "XBox Series",
            R.drawable.xbox_jurassicworldevo2,
            55.99f
        ),
        Juego("NBA 2k23", "XBox Series", R.drawable.xbox_nba2k23, 49.99f),
        Juego("Resident Evil 4 remake", "XBox Series", R.drawable.xbox_residentevil4, 79.99f),
        Juego("Riders Republic", "XBox Series", R.drawable.xbox_ridersrepublic, 60.00f),
    )
}
