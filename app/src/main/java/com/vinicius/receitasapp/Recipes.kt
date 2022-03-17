package com.vinicius.receitasapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Recipes(
    val nome: String ,
    val porcoes: String,
    val tempo: String,
    val descricao: String,
    val dificuldade: String,
) :Parcelable {
    var listRecipes = mutableListOf<Recipes>()


    fun addRecipe(recipes: Recipes) {
        listRecipes.add(recipes)
    }
    fun pickRecipes(): MutableList<Recipes> {
        return listRecipes
    }
}
