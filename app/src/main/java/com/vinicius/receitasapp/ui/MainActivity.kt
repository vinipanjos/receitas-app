package com.vinicius.receitasapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.vinicius.receitasapp.App
import com.vinicius.receitasapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }
    private val adapter by lazy { RecipeAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecipesList()

        getAllRecipes()
        setupFloatingActionButton()
    }

    private fun setupRecipesList() {
        binding.rvRecipes.setHasFixedSize(true)
        binding.rvRecipes.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvRecipes.adapter = adapter

    }


    private fun setupFloatingActionButton() {
        binding.fabAddRecipe.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getAllRecipes() {
        mainViewModel.getAll().observe(this) {
            adapter.submitList(it)
        }
    }



}