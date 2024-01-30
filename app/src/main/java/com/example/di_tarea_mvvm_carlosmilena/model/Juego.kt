package com.example.di_tarea_mvvm_carlosmilena.model

data class Juego(var nombre: String, var plataforma: String, var portada: Int, var precio: Float) {
    fun esIgual(identificador: String): Boolean {
        return (this.nombre + this.plataforma).replace(" ", "").lowercase() == identificador
    }
}

