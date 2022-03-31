package com.vinicius.receitasapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vinicius.receitasapp.data.Recipes
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

        //loadRecipeFromExtra()
    }

//    private fun loadRecipeFromExtra() {
//        intent?.extras?.getParcelable<Recipes>(Extras.RECIPE)?.let {
//
//            binding.tvRecipeName.text = it.name
//            binding.tvRecipeDifficulty.text = it.difficulty
//            binding.tvRecipeAmount.text = it.amount
//            binding.descritionResume.text = it.description
//            binding.tvRecipeTime.text = it.time
//            //it.image?.let { it1 -> binding.ivRecipeImage.setImageResource(it1) }
//
//        }
//    }
}