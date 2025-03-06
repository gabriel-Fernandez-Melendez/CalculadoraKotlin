package com.example.micalculadora.MVVM.viewmodel

import android.util.Log
import androidx.compose.material3.ButtonColors
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


class ViewModelCalculadora : ViewModel(){

    private  val _operacion = MutableStateFlow("")
    val cambiardatos =_operacion.asStateFlow()

    private  val _resultado = MutableStateFlow("")
    val resultado =_resultado.asStateFlow()
    //este metodo dara color a los botones en funcion del texto que recibe como parametro
    fun ColorDeLosBotones(boton :String): Color { //recordar que el tipo de variable que se retorna en kotlin va delante
        if (boton.equals("")||boton.equals("=")){
            return Color(0xFFFFA500)
        }
        return Color(0xFFF6F0E9)
    }

    fun Boton_Dato(texto : String){
        Log.i("se preciono el : ",texto) //para testear que se conecto bien la clase
        //hay que meter esta condicional del que el objeto no sea nulo para poder borrar y concatenar numeros en la cadena
        _operacion.value?.let {
            if (texto.equals("C")){
                _operacion.value =""
                return
            }
            if (texto.equals("=")){
                _operacion.value =_resultado.value
                return
            }

            _operacion.value=it+texto
            Log.i("los numeros son",_operacion.value.toString())
        }

    }
}
