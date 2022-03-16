package com.vinicius.receitasapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vinicius.receitasapp.databinding.RecipeItemBinding;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private final List<Receitas> recipes;

    public RecipeAdapter(List<Receitas> receitas) {
        this.recipes = receitas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RecipeItemBinding binding = RecipeItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.ViewHolder holder, int position) {
        Receitas recipe = recipes.get(position);
        Context context = holder.itemView.getContext();

        holder.binding.recipeName.setText(recipe.getNome());
        holder.binding.amountPeopleRecipe.setText(recipe.getPorcoes());
        holder.binding.difficultyRecipe.setText(recipe.getDificuldade());
        holder.binding.timeRecipe.setText(recipe.getTempo());

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, RecipeActivity.class);
            intent.putExtra(RecipeActivity.Extras.RECIPE, recipe);
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final RecipeItemBinding binding;

        public ViewHolder(RecipeItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
