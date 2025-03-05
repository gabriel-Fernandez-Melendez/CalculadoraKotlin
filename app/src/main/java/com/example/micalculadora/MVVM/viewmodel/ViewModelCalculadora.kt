package com.example.micalculadora.MVVM.viewmodel

import androidx.compose.material3.ButtonColors
import androidx.compose.ui.graphics.Color

//este metodo dara color a los botones en funcion del texto que recibe como parametro
fun ColorDeLosBotones(boton :String): Color { //recordar que el tipo de variable que se retorna en kotlin va delante
    if (boton.equals(" ")||boton.equals("=")){
        return Color(0xFFFFA500)
    }
    return Color(0xFFF6F0E9)
}