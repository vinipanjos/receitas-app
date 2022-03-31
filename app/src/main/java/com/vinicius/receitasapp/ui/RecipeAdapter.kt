package com.vinicius.receitasapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vinicius.receitasapp.data.Recipes
import com.vinicius.receitasapp.databinding.RecipeItemBinding


class RecipeAdapter : ListAdapter<Recipes, RecipeAdapter.ViewHolder>(DiffCallBack()) {

        var listenerShare: (View) ->Unit ={}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecipeItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: RecipeItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe:Recipes){
            binding.tvRecipeName.text = recipe.name
            binding.tvRecipeAmount.text = recipe.amount
            binding.tvRecipeTime.text = recipe.time
            binding.tvRecipeAmount.text = recipe.amount
            binding.cdContent.setOnClickListener {
                listenerShare(it)
            }
            //binding.ivRecipeImage.setImageResource(R.drawable.rice_img)

        }

    }


}

class DiffCallBack: DiffUtil.ItemCallback<Recipes>() {
    override fun areItemsTheSame(oldItem: Recipes, newItem: Recipes) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Recipes, newItem: Recipes) = oldItem.id == newItem.id

}
