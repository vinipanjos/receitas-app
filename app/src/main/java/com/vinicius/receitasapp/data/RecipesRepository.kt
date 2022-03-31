package com.vinicius.receitasapp.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class RecipesRepository(private val dao: RecipesDao) {

    fun insert(recipes: Recipes) = runBlocking {
        launch(Dispatchers.IO) {
            dao.insert(recipes)
        }
    }

    fun getAll() = dao.getAll()
}

