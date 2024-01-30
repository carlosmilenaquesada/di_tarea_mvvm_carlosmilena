package com.example.di_tarea_mvvm_carlosmilena.network


import com.example.di_tarea_mvvm_carlosmilena.model.Pokemon
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("pokedex.json")
    suspend fun getPokemon(): List<Pokemon>  //funcion asincrona


    companion object {
        var apiService: ApiService? = null
        fun getInstance(): ApiService {
            if (apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://raw.githubusercontent.com/carlosmilenaquesada/pokedexjsonfile/main/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return apiService!!
        }
    }
}

//https://raw.githubusercontent.com/carlosmilenaquesada/pokedexjsonfile/main/pokedex.json