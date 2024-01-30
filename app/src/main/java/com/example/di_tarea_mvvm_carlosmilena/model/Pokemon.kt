package com.example.di_tarea_mvvm_carlosmilena.model

data class Pokemon(
    val id: Int,
    val name: Name,
    val type: List<String>,
    val base: BaseStats,
    val species: String,
    val description: String,
    val evolution: Evolution,
    val profile: Profile,
    val image: Image
)

data class Name(
    val english: String,
    val japanese: String,
    val chinese: String,
    val french: String
)

data class BaseStats(
    val HP: Int,
    val Attack: Int,
    val Defense: Int,
    val SpAttack: Int,
    val SpDefense: Int,
    val Speed: Int
)


data class Evolution(
    val next: List<List<String>>
)

data class Profile(
    val height: String,
    val weight: String,
    val egg: List<String>,
    val ability: List<List<String>>,
    val gender: String
)

data class Image(
    val sprite: String,
    val thumbnail: String,
    val hires: String
)
