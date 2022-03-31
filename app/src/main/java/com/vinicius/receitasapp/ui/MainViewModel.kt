package com.vinicius.receitasapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vinicius.receitasapp.data.Recipes
import com.vinicius.receitasapp.data.RecipesRepository

class MainViewModel(private val recipesRepository: RecipesRepository) : ViewModel() {

    fun insert(recipes: Recipes) {
        recipesRepository.insert(recipes)
    }

    fun getAll(): LiveData<List<Recipes>> {
        return recipesRepository.getAll()
    }
}

class MainViewModelFactory(private val repository: RecipesRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}