package com.vinicius.receitasapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.vinicius.receitasapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var recipes: List<Recipes>
    lateinit var recipe: Recipes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recipe = Recipes("", "", "", "", "")

        addDefaultRecipes()
//        addNewRecipe(recipe)
        setupRecipeList()
        setupFloatingActionButton()
        setupRecipesRefresh()

    }

    private fun addDefaultRecipes() {
//        recipes = mutableListOf(Recipes("Macarrao", "5", "50", "Massa", "Facil"),
//            Recipes("Pizza", "8", "100", "Massa", "Dificil"),
//            Recipes("Feijao", "20", "50", "Proteina", "Facil"),
//            Recipes("Paçoca", "40", "50", "Doce", "Médio"),
//            Recipes("Arroz", "6", "30", "Carboidrato", "Facil"))
        recipe.addRecipe(Recipes("Macarrao", "5", "50", "Massa", "Facil"))
        recipe.addRecipe(Recipes("Pizza", "8", "100", "Massa", "Dificil"))
        recipe.addRecipe(Recipes("Feijao", "20", "50", "Proteina", "Facil"))
        recipe.addRecipe(Recipes("Paçoca", "40", "50", "Doce", "Médio"))
        recipe.addRecipe(Recipes("Arroz", "6", "30", "Carboidrato", "Facil"))

    }

    private fun addNewRecipe() {
        recipe.addRecipe(Recipes("", "", "", "", ""))

    }

    private fun setupRecipesRefresh() {
        //TODO Fazer a atualização na ação de swipe
        binding.srlRecipes.setOnRefreshListener {
            setupRecipeList()
            binding.srlRecipes.isRefreshing = false }
    }

    private fun setupFloatingActionButton() {
        binding.facAddRecipe.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)

        }
    }

    private fun setupRecipeList() {
        binding.rvRecipes.setHasFixedSize(true)
        binding.rvRecipes.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvRecipes.adapter = RecipeAdapter(recipe.listRecipes)

    }
}