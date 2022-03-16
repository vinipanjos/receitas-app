package com.vinicius.receitasapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Receitas(
    val nome: String ,
    val porcoes: String,
    val tempo: String,
    val descricao: String,
    val dificuldade: String,
) :Parcelable
