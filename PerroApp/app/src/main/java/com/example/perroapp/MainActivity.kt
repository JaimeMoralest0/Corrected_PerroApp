

package com.example.perroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.perroapp.ui.theme.PerroAppTheme
import com.example.perroapp.ui.screens.DogListScreen
import com.example.perroapp.viewmodel.DogViewModel

class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Aplico el tema que definimos para la app
            PerroAppTheme {

                // Inicializo el ViewModel que se usará en la UI
                val dogViewModel: DogViewModel by viewModels()

                // Surface es un contenedor que se adapta al tema de la app
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    // Paso el ViewModel a la pantalla de la lista de perros
                    DogListScreen(dogViewModel)
                }
            }
        }
    }
}
