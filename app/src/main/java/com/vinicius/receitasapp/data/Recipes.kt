package com.vinicius.receitasapp.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Recipes(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String?,
    val amount: String?,
    val time: String?,
    val description: String?,
    val difficulty: String?
    //val image: Uri?
) : Parcelable
//    var listRecipes = mutableListOf<Recipes>()

//    (Recipes("Macarrao", "5", "50", "Massa", "Facil", R.drawable.spaghetti_img),
//        Recipes("Pizza", "8", "100", "Massa", "Dificil", R.drawable.pizza_img),
//        Recipes("Feijao", "20", "50", "A água quente faz com que o feijão cozinhe mais rápido. Tampe a panela e quando começar a pegar pressão, marque 15 minutos. Se quiser um feijão com um caldo mais grosso, deixe por 20 minutos. Depois é só servir.", "Facil", R.drawable.bean_img),
//        Recipes("Paçoca", "40", "50", "Doce", "Médio", R.drawable.peanut_candy_img),
//        Recipes("Arroz", "6", "30", "Carboidrato", "Facil", R.drawable.rice_img),
//        Recipes("Ovo", "1", "4", "Fritar o ovo e não deixar queimar", "Facil", R.drawable.egg_img)
//    )



