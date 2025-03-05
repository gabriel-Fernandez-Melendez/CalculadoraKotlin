package com.example.micalculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.micalculadora.MVVM.view.PracticaCalculadora
import com.example.micalculadora.MVVM.viewmodel.ViewModelCalculadora
import com.example.micalculadora.ui.theme.MiCalculadoraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val Calculadora_viewModel =ViewModelProvider(this)[ViewModelCalculadora::class.java] //esta es la aplicacion de mvvm,desde aqui es como puedo llamar a los metodos declarados en el viewmodel
        enableEdgeToEdge()
        setContent {
            MiCalculadoraTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PracticaCalculadora(modifier = Modifier.padding(innerPadding),Calculadora_viewModel) //hay que pasar este argumento a la funcion o da error por el modifier que tiene el Scaffold;
                }
            }
        }
    }
}

