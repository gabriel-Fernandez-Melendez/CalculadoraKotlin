package com.example.micalculadora.MVVM.model

//en el modelo metere la llamada a la funcion donde estara la lista de botones a implementar, los  botones naranjas no  voy a ponerles texto

fun ListaDeBotones():List<String>{
    val lista = listOf(
        "C", "", "", "÷",
        "7", "8", "9", "*",
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "", "0", "", "="
    )
    return lista
}

