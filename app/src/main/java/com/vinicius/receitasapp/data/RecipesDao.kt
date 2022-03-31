package com.vinicius.receitasapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RecipesDao {
    @Query("SELECT * FROM Recipes")
    fun getAll(): LiveData<List<Recipes>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(recipes: Recipes)

}