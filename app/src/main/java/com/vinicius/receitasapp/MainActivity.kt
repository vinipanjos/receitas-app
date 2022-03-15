package com.vinicius.receitasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.vinicius.receitasapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var recipeAdapter:RecipeAdapter
    lateinit var receitas: List<Receitas>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        receitas = listOf(Receitas("Macarrao", "5", "50", "oaskoask", "Dificil"),
            Receitas("Pizza", "5", "100", "oaskoask", "Dificil"),
            Receitas("Feijao", "5", "50", "oaskoask", "Dificil"),
            Receitas("Paçoca", "5", "50", "oaskoask", "Dificil"),
            Receitas("Arroz", "5", "50", "oaskoask", "Dificil"))


        SetupRecipeList();
    }


    private fun SetupRecipeList() {
        binding.rvRecipes.setHasFixedSize(true)
        binding.rvRecipes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvRecipes.adapter = RecipeAdapter(receitas)
        //recipeAdapter =  RecipeAdapter(receitasAdapter)

    }
}