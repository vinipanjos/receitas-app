package com.vinicius.receitasapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vinicius.receitasapp.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddBinding
    lateinit var recipe: Recipes
    lateinit var recipeAdapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recipe = Recipes("","","","","")

        binding.button.setOnClickListener {
            recipe.addRecipe(
                Recipes(
                    binding.nameAdd.toString(),
                    binding.amountAdd.toString(),
                    binding.timeAdd.toString(),
                    binding.descriptionAdd.toString(),
                    binding.difficultyAdd.toString()
                )
            )

        }

    }
}