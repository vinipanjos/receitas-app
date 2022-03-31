package com.vinicius.receitasapp

import android.app.Application
import com.vinicius.receitasapp.data.RecipesDatabase
import com.vinicius.receitasapp.data.RecipesRepository

class App : Application() {
    val database by lazy { RecipesDatabase.getDatabase(this) }
    val repository by lazy{ RecipesRepository(database.recipesDao())}
}