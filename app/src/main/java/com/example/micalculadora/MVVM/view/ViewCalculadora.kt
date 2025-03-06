package com.example.micalculadora.MVVM.view

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.micalculadora.MVVM.model.ListaDeBotones

import com.example.micalculadora.MVVM.viewmodel.ViewModelCalculadora

val viewModel: ViewModelCalculadora = ViewModelCalculadora()
@Composable
fun PracticaCalculadora(modifier: Modifier =Modifier,viewModel: ViewModelCalculadora){
    val activity = LocalContext.current as Activity
    //variables que cargan los datos del viewmodel
    val calculo = viewModel.operacion.observeAsState()
    val resultado = viewModel.resultado.observeAsState()
Column( modifier = Modifier
    .fillMaxSize()
    .fillMaxWidth()
    .background(Color.White)
    .padding(bottom = 50.dp),
    horizontalAlignment = Alignment.End) //eliminar luego el color era para ver que estaba bien(ESTA COLUMNA ES LA CONTENEDORA DE LA VENTANA,no se puede declarar el horizontalalighment en la segunda)
    {
        Row(modifier = Modifier.fillMaxWidth().background(Color.White).padding(top = 45.dp))
        {
            Image(
                modifier = Modifier.size(40.dp).padding(start = 10.dp),
                contentDescription = "Imagen calculadora",
                painter = painterResource(id = com.example.micalculadora.R.drawable.calculadora),
            )
            Text(text = "Mi calculadora", fontSize = 20.sp, modifier = Modifier.padding(start = 10.dp, top = 8.dp))
            Icon(Icons.Default.Clear, contentDescription = " ",
                Modifier.clickable {activity.finish() }
                    .padding(start =180.dp).size(20.dp))
        }
    Column(modifier = Modifier.padding(top = 20.dp), horizontalAlignment = Alignment.End) // esto para que el texto se pege a la izquierda
    {
        Spacer(modifier = Modifier.size(30.dp))
        //tenemos que darle un padding al lateral para que encaje de forma correcta(este texto muestra la operacion)
        Text(text = calculo.value.toString()?:" ", //le damos un  valor vacio a la cadena si es null (al principio del programa)
            textAlign = TextAlign.End, //creo que esta segunda llamada no aplica podria quitarse
            fontSize = 26.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis, //esto hace que si el texto es mas largo que la linea pone 3 puntos al final
            modifier = Modifier.padding(end = 18.dp)
        )
        Spacer(modifier.size(10.dp))
        //este texto muestra el resultado
        Text(text = resultado.value.toString()?:" ",
            textAlign = TextAlign.End, //creo que esta segunda llamada no aplica podria quitarse
            fontSize = 50.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(end = 18.dp)
        )
        Spacer(modifier.size(10.dp))
        LazyVerticalGrid(columns = GridCells.Fixed(4)//esto para el numero de columnas que tendra la calculadora
        )
        {
    items(ListaDeBotones()){
        var textoBoton =it.toString()
        Button(onClick = {viewModel.Boton_Dato(textoBoton)},
            modifier = Modifier.size(80.dp).padding(10.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = viewModel.ColorDeLosBotones(textoBoton)) //para pasar un color como argumento hay que encapsularlo en buttoncolors
            )
        {
            Text(text = it, color = Color.Black, fontSize = 20.sp)
        }
    }
        }
    }

    }
    Spacer(modifier = Modifier.size(110.dp))
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreviewLogin_Instagram() {
    PracticaCalculadora(Modifier,viewModel )
}