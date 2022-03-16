package com.vinicius.receitasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vinicius.receitasapp.databinding.ActivityRecipeBinding

class RecipeActivity : AppCompatActivity() {

    object Extras {
        const val RECIPE = "EXTRA_RECIPE"
    }

    private lateinit var binding: ActivityRecipeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}