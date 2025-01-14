
package com.example.perroapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.perroapp.network.RetrofitInstance
import com.example.perroapp.model.Dog
import kotlinx.coroutines.launch

class DogViewModel : ViewModel() {

    // Lista que almacena los perros obtenidos de la API
    private val _dogs = mutableListOf<Dog>()
    var dogs: List<Dog> = _dogs

    init {
        // Llamo a la función para obtener los perros cuando se cree el ViewModel
        fetchDogs()
    }

    // Función para obtener los perros desde la API
    private fun fetchDogs() {
        viewModelScope.launch {
            try {
                // Realizo la llamada a la API usando Retrofit
                val response = RetrofitInstance.api.getBreeds()
                if (response.isNotEmpty()) {
                    _dogs.clear()  // Limpio la lista actual
                    _dogs.addAll(response)  // Agrego los nuevos perros obtenidos
                    dogs = _dogs
                    Log.d("DogViewModel", "Fetched ${response.size} dogs")
                } else {
                    Log.d("DogViewModel", "API returned an empty list")
                }
            } catch (e: Exception) {
                // Si ocurre un error, se muestra en el log
                Log.e("DogViewModel", "Error fetching dogs", e)
            }
        }
    }
}
