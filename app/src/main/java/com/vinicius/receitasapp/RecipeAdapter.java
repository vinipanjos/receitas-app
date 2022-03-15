package com.vinicius.receitasapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vinicius.receitasapp.databinding.RecipeItemBinding;

import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {

    private List<Receitas> receitas;

    public RecipeAdapter(List<Receitas> receitas) {
        this.receitas = receitas;
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
        Receitas receita = receitas.get(position);

        holder.binding.recipeName.setText(receita.getNome());
        holder.binding.amountPeopleRecipe.setText(receita.getPorcoes());
        holder.binding.difficultyRecipe.setText(receita.getDificuldade());
        holder.binding.timeRecipe.setText(receita.getTempo());

    }

    @Override
    public int getItemCount() {
        return receitas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final RecipeItemBinding binding;

        public ViewHolder(RecipeItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
